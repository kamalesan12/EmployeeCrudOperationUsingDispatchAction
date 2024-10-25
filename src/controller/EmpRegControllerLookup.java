package controller;

import java.util.HashMap;
import java.util.Map;

import javax.activation.ActivationDataFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import Beans.EmpRegFormBean;
import Emp_reg_DAO.EmpRegDAO;

public class EmpRegControllerLookup extends LookupDispatchAction {

	@Override
	protected Map getKeyMethodMap() {
		Map m=new HashMap();
		m.put("save","empsave");
		m.put("update","empupdate");
		return m;
	}

	public ActionForward empsave(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		EmpRegFormBean EmpRF=(EmpRegFormBean) form;
		
		EmpRegDAO empda=new EmpRegDAO();
		int i=empda.save(EmpRF.getId(), EmpRF.getName(), EmpRF.getEmail(), EmpRF.getAddress());
		if(i!=0)
			return mapping.findForward("success"); 
		else
			return mapping.findForward("failure");
	}
	
	public ActionForward empupdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
				EmpRegFormBean EmpRF=(EmpRegFormBean) form;
				EmpRegDAO empda=new EmpRegDAO();
				boolean b=empda.update(EmpRF.getId(), EmpRF.getName(), EmpRF.getEmail(), EmpRF.getAddress());
				if(b==true)
					return mapping.findForward("success");
				else
					return mapping.findForward("failure");				
			}

}
