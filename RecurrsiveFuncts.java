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

public class RecurrsiveFuncts implements compiler.Visitor{
	ReferenceToken rt = null;
	SymbolTable st;
	
	public RecurrsiveFuncts(SymbolTable st){
		this.st = st;
	}

	@Override
	public void visit(ClassNode dn) {

	}

	@Override
	public void visit(MethodNode dn) {
		this.rt = st.getById(dn.getId());
	}
	
	@Override
	public void visit(DefNode dn) {

	}
	
	@Override
	public void visit(IdentityNode dn) {}

	@Override
	public void visit(IdentityParamListNode dn) {}

	@Override
	public void visit(NodeList dn) {}

	@Override
	public void visit(BreakNode dn) {}

	@Override
	public void visit(CaseStatementNode dn) {}

	@Override
	public void visit(CaseBlockNode dn) {}

	@Override
	public void visit(CinNode dn) {}

	@Override
	public void visit(CoutNode dn) {}

	@Override
	public void visit(IfNode dn) {}

	@Override
	public void visit(NewNode dn) {}

	@Override
	public void visit(ReturnNode dn) {}

	@Override
	public void visit(SwitchNode dn) {}

	@Override
	public void visit(ThisNode dn) {}

	@Override
	public void visit(WhileNode dn) {}

	@Override
	public void visit(AssignExpressionNode dn) {}

	@Override
	public void visit(BinaryExpressionNode dn) {}

	@Override
	public void visit(ExpressionNode dn) {}

	@Override
	public void visit(UnaryExpressionNode dn) {}

	@Override
	public void visit(BoolNode dn) {}

	@Override
	public void visit(CharNode dn) {}

	@Override
	public void visit(LeftHandSideNode dn) {}

	@Override
	public void visit(LValSuffixNode dn) {
		
		if(rt!=null && dn.getId().getValue().equals(rt.getId()) && dn.getId().getParentScope() == rt.getScope() ) {
			rt.addStackVar(rt.getType());
			dn.getId().isStackVar();
		}else if(rt!=null) {
			//System.out.println(rt.getId()+" "+dn.getId().getValue()+" "+rt.isParam()+" "+rt.getOffset());
		}
	}

	@Override
	public void visit(NullNode dn) {}

	@Override
	public void visit(NumberNode dn) {}

	@Override
	public void visit(ReferenceNode dn) {}

	
}
