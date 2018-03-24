/**
 * 
 */
package com.cminsurance.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.cminsurance.model.EnsurancePolicy;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean(name = "ensurancePoliciesService")
@ApplicationScoped
public class EnsurancePoliciesService {
	public TreeNode createDocuments() {
        TreeNode root = new DefaultTreeNode(new EnsurancePolicy("Policies", "-", "Folder"), null);
         
        TreeNode autoEnsurance = new DefaultTreeNode(new EnsurancePolicy("Documents", "-", "Folder"), root);
        
        TreeNode autoAzul = new DefaultTreeNode(new EnsurancePolicy("Azul Auto HB20", "60 KB", "PDF File"), autoEnsurance);
        
         
        return root;
    }
}
