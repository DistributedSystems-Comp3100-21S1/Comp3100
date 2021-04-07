package data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "server")
public class Server implements Comparable<Server> {

    private String type;
    private String limit;
    private String bootupTime;
    private String hourlyRate;
    private int coreCount;
    private int memory;
    private int disk;

    public void setType(String type) {
        this.type = type;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void setBootupTime(String bootupTime) {
        this.bootupTime = bootupTime;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    @XmlAttribute(name = "type")
    public String getType() {
        return type;
    }

    @XmlAttribute(name = "limit")
    public String getLimit() {
        return limit;
    }

    @XmlAttribute(name = "bootupTime")
    public String getBootupTime() {
        return bootupTime;
    }

    @XmlAttribute(name = "hourlyRate")
    public String getHourlyRate() {
        return hourlyRate;
    }

    @XmlAttribute(name = "coreCount")
    public int getCoreCount() {
        return coreCount;
    }

    @XmlAttribute(name = "memory")
    public int getMemory() {
        return memory;
    }

    @XmlAttribute(name = "disk")
    public int getDisk() {
        return disk;
    }

    @Override
    public String toString() {
        return "type: " + type +
                " limit: " +
                limit +
                " bootupTime: " +
                bootupTime +
                " hourlyRate: " +
                hourlyRate +
                " coreCount: " +
                coreCount +
                " memory: " +
                memory +
                " disk: " +
                disk;
    }

    @Override
    public int compareTo(Server server) {
        int coreComparison = Integer.compare(coreCount, server.coreCount);
        int memoryComparison = Integer.compare(memory, server.memory);
        int diskComparison = Integer.compare(disk, server.disk);
        return coreComparison != 0 ? coreComparison : memoryComparison != 0 ? memoryComparison : diskComparison;
    }
}
