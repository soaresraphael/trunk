/**
 * Nome: com.msprojectreport.model
 *
 * Finalidade: Classes de uso comum para a funcionalidade
 * Data da Cria��o: 06/06/2016
 *
 */
package com.cminsurance.model;

import java.io.Serializable;
import java.util.Date;


/**
 * Nome: ProjectTask Finalidade: Classe criada para.
 *
 * @author raphael.soares
 */
public class ProjectTask implements Serializable, Comparable<ProjectTask> {

	private static final long serialVersionUID = 2708232150298069676L;

	private Integer id;

	/** Atributo task name. */
	private String taskName;

	/** Atributo percentage planned. */
	private Double percentagePlanned;

	/** Atributo percentage complete. */
	private Double percentageComplete;

	/** Atributo date. */
	private String TaskDate;

	/** Atributo initialDate. */
	private Date initialDate;

	/** Atributo final date. */
	private Date finalDate;

	private String duration;

	private String work;

	private String resourceNames;

	private String outlineNumber = null;

	private boolean child = false;

	private String parent = null;


	/**
	 * <dt><b>Nome:</b><dt> <dd>getParent</dd>
	 * <dt><b>Prop�sito:</b><dt>
	 * <dd>retornar o valor do campo parent</dd>
	 *
	 * @author pemoreir
	 * @return o valor do campo parent
	 *
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * <dt><b>Nome:</b><dt> <dd>setParent</dd>
	 * <dt><b>Prop�sito:</b><dt>
	 * <dd>definir o valor do campo parent</dd>
	 *
	 * @author pemoreir
	 * @param parent novo valor para o campo parent
	 *
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * <dt><b>Nome:</b><dt> <dd>isChild</dd>
	 * <dt><b>Prop�sito:</b><dt>
	 * <dd>retornar o valor do campo isChild</dd>
	 *
	 * @author pemoreir
	 * @return o valor do campo isChild
	 *
	 */
	public boolean getChild() {
		return this.child;
	}

	/**
	 * <dt><b>Nome:</b><dt> <dd>setChild</dd>
	 * <dt><b>Prop�sito:</b><dt>
	 * <dd>definir o valor do campo isChild</dd>
	 *
	 * @author pemoreir
	 * @param theNewChildParam novo valor para o campo isChild
	 *
	 */
	public void setChild(boolean theNewChildParam) {
		this.child = theNewChildParam;
	}

	/**
	 * <dt><b>Nome:</b><dt> <dd>getOutlineNumber</dd>
	 * <dt><b>Prop�sito:</b><dt>
	 * <dd>retornar o valor do campo outlineNumber</dd>
	 *
	 * @author pemoreir
	 * @return o valor do campo outlineNumber
	 *
	 */
	public String getOutlineNumber() {
		return outlineNumber;
	}

	/**
	 * <dt><b>Nome:</b><dt> <dd>setOutlineNumber</dd>
	 * <dt><b>Prop�sito:</b><dt>
	 * <dd>definir o valor do campo outlineNumber</dd>
	 *
	 * @author pemoreir
	 * @param outlineNumber novo valor para o campo outlineNumber
	 *
	 */
	public void setOutlineNumber(String outlineNumber) {
		this.outlineNumber = outlineNumber;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	private double percentageWorkComplete;

	public double getPercentageWorkComplete() {
		return percentageWorkComplete;
	}

	public void setPercentageWorkComplete(double percentageWorkComplete) {
		this.percentageWorkComplete = percentageWorkComplete;
	}

	/**
	 * @return the work
	 */
	public String getWork() {
		return work;
	}

	/**
	 * @param work the work to set
	 */
	public void setWork(String work) {
		this.work = work;
	}


	// Recupera o valor do atributo 'TaskDate'.
	public String getTaskDate() {
		return TaskDate;
	}

	// setTaskDate Recupera o valor do atributo 'TaskDate'.
	public void setTaskDate(String taskDate) {
		TaskDate = taskDate;
	}

	// Recupera o valor do atributo 'InitialDate'.
	public Date getInitialDate() {
		return initialDate;
	}

	// setInitialDate Recupera o valor do atributo 'InitialDate'.
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	// Recupera o valor do atributo 'FinalDate'.
	public Date getFinalDate() {
		return finalDate;
	}

	// setFinalDate Recupera o valor do atributo 'finalDate'.
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	/**
	 * Nome: getTaskName Recupera o valor do atributo 'taskName'.
	 *
	 * @return valor do atributo 'taskName'
	 */
	public String getTaskName() {
		return taskName;
	}


	public String getResourceNames() {
		return resourceNames;
	}

	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}

	/**
	 * Nome: setTaskName Registra o valor do atributo 'taskName'.
	 *
	 * @param taskName
	 *            valor do atributo task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Nome: getPercentagePlanned Recupera o valor do atributo
	 * 'percentagePlanned'.
	 *
	 * @return valor do atributo 'percentagePlanned'
	 */
	public Double getPercentagePlanned() {
		return percentagePlanned;
	}

	/**
	 * Nome: setPercentagePlanned Registra o valor do atributo
	 * 'percentagePlanned'.
	 *
	 * @param percentagePlanned
	 *            valor do atributo percentage planned
	 */
	public void setPercentagePlanned(Double percentagePlanned) {
		this.percentagePlanned = percentagePlanned;
	}

	/**
	 * Nome: getPercentageComplete Recupera o valor do atributo
	 * 'percentageComplete'.
	 *
	 * @return valor do atributo 'percentageComplete'
	 */
	public Double getPercentageComplete() {
		return percentageComplete;
	}

	/**
	 * Nome: setPercentageComplete Registra o valor do atributo
	 * 'percentageComplete'.
	 *
	 * @param percentageComplete
	 *            valor do atributo percentage complete
	 */
	public void setPercentageComplete(Double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int compareTo(ProjectTask outraTarefa) {
		return id.compareTo(outraTarefa.getId());
	}
  }
