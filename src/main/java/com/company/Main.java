package com.company;

public class Main {

    public static CSVReader csv = new CSVReader();

    public static void readVMs(String filename, AbstractBalancer b){
        csv.readVM(filename,b);
    }

    public static void readHWs(String filename, AbstractBalancer b){
        csv.readHW(filename,b);
    }

    public static void  write(String filename, AbstractBalancer b) {
        csv.writeFile(b,filename);
    }

    public static void main(String[] args) {
	// write your code here
        AbstractBalancer[] arr = new AbstractBalancer[6];
        arr[0] = new MinCpuBalancer();
        arr[0].name = "MinCPU";
        arr[1] = new MinMemoryBalancer();
        arr[1].name = "MinMem";
        arr[2] = new MinNetzBalancer();
        arr[2].name = "MinNetz";
        arr[3] = new MinNLBalancer();
        arr[3].name = "MinNL";
        arr[4] = new RandomBalancer();
        arr[4].name = "Random";
        arr[5] = new RoundRobinBalancer();
        arr[5].name = "RoundRobin";
        for(int i = 100;i<=10000;i*=10){
            for(AbstractBalancer b: arr ){
                b.clearHW();
                readHWs("HWRessources"+i+"_random.csv",b);
            }
            for(int j = 1000; j <= 10000; j*=10){
                for(AbstractBalancer b: arr ){
                    b.clearVMS();
                    readVMs("VMHistory"+j+".csv",b);
                    b.balance();
                    write(b.name+"_HW"+i+"_VM"+j+".csv",b);
                }
            }
        }
        System.out.println("Finish");
    }
}
