package astCreation;

import drive.ExpType;

/**
 * BinaryExpressionNode extends the expressionNode it contains
 * a lefthand side of any node type a right hand side of any node
 * type and an aperation between the two.
 * -If updating I may make more specific binaryExpressionNodes. ie a
 * binaryLogicalExpression, BinaryArithmatic, BinaryComparison. or even more BinAddition/binMult/binAnd
 * @author Delia
 *
 */
public class BinaryExpressionNode extends ExpressionNode {
	//members
	ExpType operation;
	ASTNode exp1;
	ASTNode exp2;
	int lineNo;
	int uniqueNo;
	static int count =0;
	
	public BinaryExpressionNode(){
		this.operation = ExpType.ADD;
		this.uniqueNo = count++;
		this.exp1 = null;
		this.exp2 = null;
	}
	
	public BinaryExpressionNode(ExpType op){
		this.operation = op;
		this.uniqueNo = count++;
		exp1 = null;
		exp2 = null;
	}
	
	public BinaryExpressionNode(String operative, ASTNode expA, ASTNode expB){
		ExpType op = operationVal(operative);
		this.operation = op;
		this.uniqueNo = count++;
		exp1 = expA;
		exp2 = expB;
	}
	
	public void setLineNo(int line) {
		this.lineNo = line;
	}
	
	public int getLineNo() {
		return this.lineNo;
	}
	
	public ASTNode getExp1() {
		return exp1;
	}

	public void setExp1(ASTNode exp1) {
		this.exp1 = exp1;
	}

	public ASTNode getExp2() {
		return exp2;
	}

	public void setExp2(ASTNode exp2) {
		this.exp2 = exp2;
	}

	public ExpType getOperation() {
		return this.operation;
	}
	
	public void setOperation(ExpType op) {
		this.operation = op;
	}
	
	public void setOperation(String op) {
		this.operation = operationVal(op);
	}
	
	/**
	 * operationVal takes a string and returns the referenced
	 * expression type(ExpType) (Addition, Multiplication, AND...)
	 * @param op
	 * @return ExpType
	 */
	public ExpType operationVal(String op) {
		ExpType opVal = ExpType.ADD;
		if(op.equals("/")) {
			opVal = ExpType.DIV;
		}else if(op.equals("*")) {
			opVal = ExpType.MUL;
		}else if(op.equals("-")) {
			opVal = ExpType.SUB;
		}else if(op.equals("<")) {
			opVal = ExpType.LT;
		}else if(op.equals("<=")) {
			opVal = ExpType.LTE;
		}else if(op.equals("==")) {
			opVal = ExpType.EE;
		}else if(op.equals(">")) {
			opVal = ExpType.GT;
		}else if(op.equals(">=")) {
			opVal = ExpType.GTE;
		}else if(op.equals("&&")) {
			opVal = ExpType.AND;
		}else if(op.equals("=")) {
			opVal = ExpType.ASSN;
		}else if(op.equals("||")) {
			opVal = ExpType.OR;
		}else if(op.equals("+=")) {
			opVal = ExpType.ADDASSN;
		}else if(op.equals("-=")) {
			opVal = ExpType.SUBASSN;
		}else if(op.equals("*=")) {
			opVal = ExpType.MULASSN;
		}else if(op.equals("/=")) {
			opVal = ExpType.DIVASSN;
		}else if(op.equals("!=")) {
			opVal = ExpType.NOTE;
		}
			
		return opVal;
	}
	
	@Override
	public String getLabel() {
		return this.operation+"_"+Integer.toString(this.uniqueNo);
	}
	
	public void accept(compiler.Visitor visit) {
		visit.visit(this);
		if(this.exp1 != null) {
			this.exp1.accept(visit);
		}else {System.out.println("Missing exp1");}
		if(this.exp2!= null) {
			this.exp2.accept(visit);
		}else {System.out.println("Missing exp2");}
	}
	
	public void accept(compiler.VisitorPost visit) {
		visit.visit(this);
		if(this.exp1 != null) {
			this.exp1.accept(visit);
			
		}else {System.out.println("Missing exp1");}
		if(this.exp2!= null) {
			this.exp2.accept(visit);
		}else {System.out.println("Missing exp2");}
		visit.postVisit(this);
	}
	
	@Override
	public ASTNode[] getChildren() {
		if(this.exp1 != null && this.exp2 != null) {
			return new ASTNode[] {this.exp1,this.exp2};
		}else if(this.exp1!=null) {
			return new ASTNode[] {this.exp1};
		}else if(this.exp2!=null) {
			return new ASTNode[] {this.exp2};
		} else return null;
	}
	
	@Override
	public void visit() {
		if(this.exp1 != null) {
			this.exp1.visit();
		}else {System.out.println("Missing exp1");}
		if(this.exp2!= null) {
			this.exp2.visit();
		}else {System.out.println("Missing exp2");}
	}
	
}
