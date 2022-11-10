package astCreation;

import drive.Modifier;
import drive.Types;

public class IdentityNode extends LeftHandSideNode {
	static int count =0;
	int lineNo;
	Modifier mod;
	Types type;
	String classType;
	String mangled;
	String name;
	int prntScope;
	int scope;
	int size;
	int offset;
	int uniqueNo;
	boolean isMethod;
	boolean isParam;
	boolean assigned;
	
	public IdentityNode() {
		this.mod = Modifier.UNDEFINED;
		this.type = Types.VOID;
		this.mangled = "";
		this.name = "";
		this.prntScope = 0;
		this.scope = 0;
		this.size = 0;
		this.offset =0;
		this.uniqueNo = count++;
		this.isMethod = false;
		this.assigned = false;
		this.isParam = false;
	}
	
	public IdentityNode(String nm) {
		this.mod = Modifier.UNDEFINED;
		this.type = Types.VOID;
		this.mangled = "";
		this.name = nm;
		this.prntScope = 0;
		this.scope = 0;
		this.size = 0;
		this.offset =0;
		this.uniqueNo = count++;
		this.isMethod = false;
		this.assigned = false;
		this.isParam = false;
	}
	
	public IdentityNode(String t, String nm) {
		this.mod = Modifier.UNDEFINED;
		this.type = getTypeVal(t); //sets size
		this.mangled = mangleName("Global"+t+nm);
		this.name = nm;
		this.prntScope = 0;
		this.scope = 0;
		//this.size = this.type.getSize();
		this.offset =0;
		this.uniqueNo = count++;
		this.isMethod = false;
		this.assigned = false;
		this.isParam = false;
	}
	
	public IdentityNode(String arr, String t, String nm) {
		this.mod = Modifier.UNDEFINED;
		this.type = getTypeVal(arr,t);
		this.mangled = mangleName("Global"+t+nm);
		this.name = nm;
		this.prntScope = 0;
		this.scope = 0;
		//this.size = this.type.getSize();
		this.uniqueNo = count++;
		this.isMethod = false;
		this.assigned = false;
		this.isParam = false;
	}
	
	public void assigned() {
		this.assigned = true;
	}
	
	public void setParam() {
		this.isParam = true;
	}
	
	public boolean isParam() {
		return this.isParam;
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
	
	public String getClassType() {
		return this.classType;
	}
	
	public void setClassType(String cT) {
		this.classType = cT;
	}
	
	public boolean getIsMethod() {
		return this.isMethod;
	}
	
	public void assertIsMethod() {
		this.isMethod = true;
	}
	
	public void setOffset(int off) {
		this.offset = off;
	}
	
	public int getOffset() {
		return this.offset;
	}
	
	public void setTypeVal(String t) {
		this.type = getTypeVal(t);
		this.size = this.type.getSize();
	}
	
	public Types getTypeVal(String t) {
		//System.out.println("Inside IDNode "+t);
		Types typeV= Types.NULL;
		if(t==null) {
			return typeV;
		}
		if(t.equals("int")) {
			typeV = Types.INT;
		}else if(t.equals("char")) {
			typeV = Types.CHAR;
		}else if(t.equals("bool")) {
			typeV = Types.BOOL;
		}else if(t.equals("void")){
			typeV = Types.VOID;
		}else if(t.equals("intarr")){
			typeV = Types.INTARR;
		}else if(t.equals("chararr")){
			typeV = Types.CHARARR;
		}else if(t.equals("boolarr")){
			typeV = Types.BOOLARR;
		}else if(t.equals("voidarr")){
			typeV = Types.VOIDARR;
		}else if(t.equals("classarr")){
			typeV = Types.CLASSARR;
		}else {
			typeV = Types.CLASS;
			this.classType = t;
		}
		return typeV;
	}
	
	public Types getTypeVal(String a, String t) {
		Types typeV ; //void
		if(t.equals("int")) {
			typeV = Types.INTARR;
		}else if(t.equals("char")) {
			typeV = Types.CHARARR;
		}else if(t.equals("bool")) {
			typeV = Types.BOOLARR;
		}else if(t.equals("void")){
			typeV = Types.VOIDARR;
		}else {
			typeV = Types.CLASSARR;
			this.classType = t;
		}
		return typeV;
	}
	
	public Modifier getModifierVal(String mod) {
		Modifier modified = Modifier.UNDEFINED;//undefined
		if(mod.equals("public")) {
			modified = Modifier.PUBLIC;
		}else if (mod.equals("private")) {
			modified = Modifier.PRIVATE;
		}else if (mod.equals("protected")) {
			modified = Modifier.PROTECTED;
		}
		return modified;
	}
	
	public String mangleName(String nm) {
		return nm;
	}
	
	@Override
	public String getLabel() {
		if(this.type == Types.CLASS) {
			return this.mod.name()+"_"+this.classType+"_"+this.name+"_"+this.scope+"_"+Integer.toString(this.uniqueNo);
		}
		return this.mod.name()+"_"+this.type.name()+"_"+this.name+"_"+this.scope+"_"+Integer.toString(this.uniqueNo);
	}
	
	@Override
	public ASTNode[] getChildren() {
		return null;
	}
	
	@Override
	public void visit() {
		//System.out.print(this.mod +" "+ this.type +" "+ this.name +" ");
	}
	
	public void accept(compiler.Visitor visit) {
		visit.visit(this);
	}
	
	public Modifier getMod() {
		return mod;
	}

	public void setMod(Modifier mod) {
		this.mod = mod;
	}

	public void setMod(String mod) {
		this.mod = getModifierVal(mod);
	}
	
	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
		this.size = this.type.getSize();
	}

	public void setType(String type) {
		this.type = getTypeVal(type);
		this.size = this.type.getSize();
	}
	
	public int getPrntScope() {
		return prntScope;
	}

	public void setPrntScope(int prntScope) {
		this.prntScope = prntScope;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public int getSize() {
		if(this.type == Types.CLASS) {
			return this.size;
		}else {
			return this.type.getSize();
		}
	}

	public void setSize(int last) {
		this.size = last;
	}

	
	public void setMangled(String nm) {
		this.mangled = nm;
	}
	
	@Override
	public String getMangled() {
		return this.mangled;
	}
	
	public void setName(String nm) {
		this.name = nm;
	}
	
	public String getName() {
		return name;
	}	

}
