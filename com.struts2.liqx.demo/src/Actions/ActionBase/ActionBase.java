package Actions.ActionBase;

public interface ActionBase{
	public static final String SUCCESS = "success";
	public static final String NONE = "none";
	public static final String ERROR = "error";
	public static final String INPUT = "login";
	public static final String LOGIN = "login";
	
	public String execute() throws Exception;
}
