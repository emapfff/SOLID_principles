//Emil Davlityarov
//e.davlityarov@innopolis.university
import java.io.File;
abstract class Monitoring{
    public Logging logging;
    public void logData(ProcessData data){}
    public void visualizationData(){}
}


class Logging{
    private File file;
    private static Logging instance;

    private Logging(){}
    public static Logging getInstance(){
        if (instance == null){
            instance = new Logging();
        }
        return instance;
    }

    public void writeToFile(ProcessData data){
    }
    public void readFromFile(){

    }
    public void appendToFile(){

    }
    public void deleteFile(){

    }
}
class SystemProcessesMonitoring extends Monitoring{
    public Logging logging;
    public void logData(ProcessData data){

    }
    public void visualizationData(){

    }
}
class UserProcessesMonitoring extends Monitoring {
    public Logging logging;
    public void logData(ProcessData data){

    }
    public void visualizationData(){

    }
}
class ProcessingMonitoringFactory{
    public Monitoring createMonitoring(ProcessingMonitoring type){
        Monitoring monitoring = null;
        switch (type) {
            case SYSTEM -> monitoring = new SystemProcessesMonitoring();
            case USER -> monitoring = new UserProcessesMonitoring();
            default -> {
            }
        }
        return monitoring;
    }
}

enum ProcessingMonitoring{
    SYSTEM,
    USER
}
class ProcessData{
    private long PID;
    private double SHR;
    private double VIRT;
    private double CPU;
    private String OwnerName;
    private long NI;
    private String permissions;
    private  ProcessData(ProcessDataBuilder processDataBuilder){
        PID = processDataBuilder.PID;
        SHR = processDataBuilder.SHR;
        VIRT = processDataBuilder.VIRT;
        CPU = processDataBuilder.CPU;
        OwnerName = processDataBuilder.OwnerName;
        NI = processDataBuilder.NI;
        permissions = processDataBuilder.permissions;
    }
    public static  class ProcessDataBuilder{
        private long PID;
        private double SHR;
        private double VIRT;
        private double CPU;
        private String OwnerName;
        private long NI;
        private String permissions;

        public ProcessDataBuilder setPID(long PID){
            this.PID = PID;
            return this;
        }
        public ProcessDataBuilder setSHR(double SHR){
            this.SHR = SHR;
            return this;
        }
        public ProcessDataBuilder setVIRT(double VIRT){
            this.VIRT = VIRT;
            return this;
        }
        public ProcessDataBuilder setCPU(double CPU){
            this.CPU = CPU;
            return this;
        }
        public ProcessDataBuilder setOwnerName(String OwnerName){
            this.OwnerName = OwnerName;
            return this;
        }
        public ProcessDataBuilder setNI(long NI){
            this.NI = NI;
            return this;
        }
        public ProcessDataBuilder setPermissions(String permissions){
            this.permissions = permissions;
            return this;
        }
        public ProcessData build(){
            return new ProcessData(this);
        }

    }
}