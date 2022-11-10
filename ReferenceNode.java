package astCreation;

public class ReferenceNode extends ExpressionNode {
	static int count;
	
	String value = "referenceNode";
	String mangled;
	int offset =0;
	int scope;
	int size;
	int parentScope;
	int uniqueNo;
	int lineNo;
	boolean assigned;
	boolean param;
	boolean stackVar;
	
	public ReferenceNode(){
		this.uniqueNo = count++;
		this.assigned = false;
		this.param = false;
		this.stackVar = false;
	}
	
	public ReferenceNode(String v){
		this.value =v;
		this.uniqueNo = count++;
		this.assigned = false;
		this.param = false;
		this.stackVar = false;
	}
	
	public ReferenceNode(String v,int sc){
		this.value =v;
		this.parentScope = sc;
		this.uniqueNo = count++;
		this.assigned = false;
		this.param = false;
		this.stackVar = false;
	}
	
	public void assigned() {
		this.assigned = true;
	}
	
	public void isParam() {
		this.param = true;
	}
	
	public void isStackVar() {
		this.stackVar = true;
	}
	
	public boolean getStackVar() {
		return this.stackVar;
	}
	
	public boolean getParam() {
		return this.param;
	}
	
	public void setOffset(int o) {
		this.offset = o;
	}
	
	public void setSize(int s) {
		this.size = s;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getOffset() {
		return 99;
	}
	
	public void assignedNull() {
		this.assigned = false;
	}
	
	public boolean isAssigned() {
		return this.assigned;
	}
	
	
	public void setLineNo(int line) {
		this.lineNo = line;
	}
	
	public int getLineNo() {
		return this.lineNo;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public void setMangled(String st) {
		this.mangled = st;
	}
	
	@Override
	public String getMangled() {
		return this.mangled;
	}
	
	public void setScope(int value) {
		this.scope = value;
	}
	
	public int getScope() {
		return this.scope;
	}
	
	public void setParentScope(int value) {
		this.parentScope = value;
	}
	
	public int getParentScope() {
		return this.parentScope;
	}
	
	@Override
	public ASTNode[] getChildren() {
		return null;
	}
	
	@Override
	public String getLabel() {
		return value+"_"+Integer.toString(this.scope)+"_"+Integer.toString(this.parentScope);
	}
	
	public void accept(compiler.Visitor visit) {
		visit.visit(this);
	}
	
	
	
	@Override
	public void visit() {
		//System.out.println(this.value);
	}
	
}
