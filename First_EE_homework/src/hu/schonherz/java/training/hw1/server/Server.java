package hu.schonherz.java.training.hw1.server;

public abstract class Server {
	
	public enum Status { RUNNING, STOPPED };
	public enum Type { LINUX, LINUXWEB, LINUXDB, LINUXDBANDWEB, WIN, WINWEB, WINDB, WINDBANDWEB }
	
	private Type type;
	private int id;
	private String name;
	private int cpuUsage;
	private int memoryUsage;
	private Status status = Status.STOPPED;
	
	public void startServer() {
		System.out.println("The server has been started!");
	}
	
	public void stopServer() {
		System.out.println("The server has been stopped!");
	}
	
	public void restartServer() {
		System.out.println("The server has been restarted!");
	}
	
	/**
	 * @return the cpuUsage
	 */
	public int getCpuUsage() {
		return cpuUsage;
	}
	
	/**
	 * @param cpuUsage the cpuUsage to set
	 */
	public void setCpuUsage(int cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	
	/**
	 * @return the memoryUsage
	 */
	public int getMemoryUsage() {
		return memoryUsage;
	}
	
	/**
	 * @param memoryUsage the memoryUsage to set
	 */
	public void setMemoryUsage(int memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
