/**
 * Nome: com.msprojectreport.controller
 *
 * Finalidade: Classes de uso comum para a funcionalidade
 * Data da Cria��o: 26/07/2016
 *
 */
package com.cminsurance.controller;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.mpxj.Duration;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectCalendar;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.TaskContainer;
import net.sf.mpxj.TimeUnit;
import net.sf.mpxj.mpp.MPPReader;

import org.primefaces.model.UploadedFile;

import com.cminsurance.model.ProjectTask;
import com.cminsurance.util.ProjectTaskComparator;

/**
 * Nome: ReportController
 * Finalidade: Classe criada para.
 *
 * @author marcusil 2016
 * @version 1.0
 * @see: NA.
 */
public class ReportController implements Serializable {

	private static final long serialVersionUID = -7001658920328513153L;

	/** Atributo tasks. */
	TaskContainer tasks = null;

	ProjectCalendar calendario = null;

	/**
	 * Nome: getTaskList
	 * Recupera o valor do atributo 'taskList'.
	 *
	 * @param uploadedFile the uploaded file
	 * @return valor do atributo 'taskList'
	 */
	public List<ProjectTask> getTaskList(UploadedFile uploadedFile) {
		// esta criando uma nova instancia e essa instancia
		// esta atribuindo pra variavel de instancia reader
		MPPReader reader = new MPPReader();
		ProjectFile project;
		// esta criando uma nova instancia
		List<ProjectTask> listaTarefas = null;
		Map<String, ProjectTask> mapaTarefas = new HashMap<String, ProjectTask>();
		try {
			// atribuindo um valor
			project = reader.read(uploadedFile.getInputstream());
			//atribui o calendario usado no cronograma
			if (project.getCalendars() != null && !project.getCalendars().isEmpty()) {
				calendario = project.getCalendars().get(0);
			}
			// atribuindo um valor
			List<Task> tasks = Arrays.asList(project.getAllTasks().get(0));
			//Preenchendo o mapa de tarefa
			preencherTarefas(mapaTarefas, tasks, false, null);
			listaTarefas = new ArrayList<ProjectTask>(mapaTarefas.values());
			Collections.sort(listaTarefas, new ProjectTaskComparator());
		} catch (MPXJException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaTarefas;
	}

	/**
	 * Nome: preencherTarefas
	 * Preencher tarefas.
	 *
	 * @param taskList the task list
	 * @param children the children
	 * @param parentId
	 */
	private void preencherTarefas(Map<String, ProjectTask> taskList,
		List<Task> children, boolean isChild, String parentId) {
		for (int x = 0; x < children.size(); x++) {
			Task task = children.get(x);
			// esta criando uma nova instancia
			ProjectTask projectTask = new ProjectTask();
			// adiciona o id para manter a ordem das tarefas
			projectTask.setId(x);
			// gera o nome dos atributos ao carregar no cronograma

			projectTask.setTaskName(formatarNivel(task.getOutlineNumber()) + task.getName());
			// gera a porcentagem comleta de cada tarefa no
			// cronograma
			projectTask.setPercentageComplete(task.getPercentageComplete()
				.doubleValue());
			BigDecimal planejado = new BigDecimal(0.0);
			// soh eh possivel calcular o planejado se tiver um calendario associado ao cronograma
			if (calendario != null) {
				Duration diasAteHoje =
					calendario.getWork(task.getStart(), new GregorianCalendar().getTime(), TimeUnit.DAYS);
				Duration diasPlanejados = task.getDuration();
				if (diasPlanejados.compareTo(diasAteHoje) <= 0) {
					planejado = new BigDecimal(100.0);
				} else if (task.getStart().compareTo(new Date()) >= 0){
					planejado = new BigDecimal(0.0);
				}
				else {
					planejado = new BigDecimal((diasAteHoje.getDuration() / diasPlanejados.getDuration()) * 100).setScale(0, BigDecimal.ROUND_DOWN);
				}
			}
			// gera a porcentagem planejado de cada tarefa no cronograma
			projectTask.setPercentagePlanned(planejado.doubleValue());
			// o atributo gera a data inicial
			projectTask.setInitialDate(task.getStart());
			// o atributo gera a data final
			projectTask.setFinalDate(task.getFinish());

			projectTask.setPercentageWorkComplete(task.getPercentageWorkComplete().doubleValue());

			List<ResourceAssignment> resources = task.getResourceAssignments();

			Iterator<ResourceAssignment> i = resources.iterator();
			while (i.hasNext()) {
				ResourceAssignment ra = (ResourceAssignment) i.next();
				Resource r = ra.getResource();
				if(r != null) {
					projectTask.setResourceNames(r.getName());
				}
			}

			projectTask.setDuration(task.getDuration().toString());

			DecimalFormat df = new DecimalFormat("0.00");
			// o atributo gera a carga horaria do trabalho
			projectTask.setWork(df.format(task.getWork().getDuration()).concat("h"));

			projectTask.setOutlineNumber(task.getOutlineNumber());
			projectTask.setChild(isChild);
			projectTask.setParent(parentId);

			// add a lista de atividade, ignorando a primeira tarefa que � a raiz do cronograma
			//!"0".equals se for diferente de 0 ,add 1 na lista
			/*if (!"0".equals(task.getOutlineNumber())) {*/
				taskList.put(task.getOutlineNumber(), projectTask);
			//}

			// se tem subtarefas, chama o metodo recursivamente
			if (!task.getChildTasks().isEmpty()) {
				preencherTarefas(taskList, task.getChildTasks(), true, task.getOutlineNumber());

			}
		}
	}

	/**
	 * Nome: formatarNivel
	 * Formatar nivel.
	 *
	 * @param semFormatacao the sem formatacao
	 * @return string
	 */
	private String formatarNivel(String semFormatacao) {

		String nivelFormatado = null;
		//retirada casas a parti de 1.
		if(semFormatacao.startsWith("1.")){
		//a retirada come�a a parti do nivel 2
			nivelFormatado = semFormatacao.substring(2);
	   //faz o ajuntamento nivelFormatado com o -
			nivelFormatado = nivelFormatado.concat(" - ");
	   // verifica si o nivel � = a 0
		}else if("0".equals(semFormatacao)||
	   // verifica si o nivel � = a 1
				 "1".equals(semFormatacao)){
	   //atribui espa�o em branco
			nivelFormatado = "";
		} else {
	   // fazendo o ajutamento da nivelFormatado com o -
			nivelFormatado = semFormatacao.concat(" - ");

		}

		return nivelFormatado;
	}
}