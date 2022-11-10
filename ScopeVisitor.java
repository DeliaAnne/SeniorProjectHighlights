package compiler;

import astCreation.AssignExpressionNode;
import astCreation.BinaryExpressionNode;
import astCreation.BoolNode;
import astCreation.BreakNode;
import astCreation.CaseBlockNode;
import astCreation.CaseStatementNode;
import astCreation.CharNode;
import astCreation.CinNode;
import astCreation.ClassNode;
import astCreation.CoutNode;
import astCreation.DefNode;
import astCreation.ExpressionNode;
import astCreation.IdentityNode;
import astCreation.IdentityParamListNode;
import astCreation.IfNode;
import astCreation.LValSuffixNode;
import astCreation.LeftHandSideNode;
import astCreation.MethodNode;
import astCreation.NewNode;
import astCreation.NodeList;
import astCreation.NullNode;
import astCreation.NumberNode;
import astCreation.ReferenceNode;
import astCreation.ReturnNode;
import astCreation.SwitchNode;
import astCreation.ThisNode;
import astCreation.UnaryExpressionNode;
import astCreation.WhileNode;

public class ScopeVisitor implements compiler.Visitor {
	int scope;
	int prntScope;
	int grandParentScope;
	int classScope;
	int methodScope;
	boolean flip = false;
	
	public ScopeVisitor(){
		this.scope = 0;
		this.prntScope = 0;
		this.grandParentScope = 0;
	}
	
	public ScopeVisitor(int sc, int pSc){
		this.scope = sc;
		this.prntScope = pSc;
		this.grandParentScope = 0;
	}
	
	@Override
	public void visit(DefNode dn) {

	}

	@Override
	public void visit(ClassNode dn) {
		dn.getId().setScope(this.scope);
		//dn.getId().setPrntScope(0);
		//System.out.println("ID: "+dn.getId().getName()+" "+dn.getId().getScope()+" psc "+dn.getId().getPrntScope());
		this.prntScope = scope;
		scope++;
		flip = true;
		//System.out.println("classnode");
	}

	@Override
	public void visit(MethodNode dn) {
		//System.out.println("methodnode");
		dn.getId().setScope(this.scope);
		dn.getId().setPrntScope(this.prntScope);
		//System.out.println("ID: "+dn.getId().getName()+" "+dn.getId().getScope()+" psc "+dn.getId().getPrntScope());
		this.prntScope = scope;
		scope++;
		flip = true;
	}

	@Override
	public void visit(IdentityNode dn) {
		if(!flip) {
			dn.setScope(this.scope);
			dn.setPrntScope(this.prntScope);
			//System.out.println("ID: "+dn.getName()+" "+dn.getScope()+" psc "+dn.getPrntScope());
			this.scope++;
		}else {
			flip = false;
		}
	}

	@Override
	public void visit(IdentityParamListNode dn) {
		//dn.setScope(this.scope);
		//dn.setPrntScope(this.prntScope);
		//System.out.println("IdPl"+dn.getName()+" "+dn.getScope());
		//this.scope++;
	}

	@Override
	public void visit(NodeList dn) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(BreakNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CaseStatementNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CaseBlockNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CinNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CoutNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IfNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NewNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ReturnNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SwitchNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ThisNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(WhileNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(AssignExpressionNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BinaryExpressionNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExpressionNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnaryExpressionNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BoolNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CharNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LeftHandSideNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LValSuffixNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NullNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NumberNode dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ReferenceNode dn) {
		// TODO Auto-generated method stub
	}

}
