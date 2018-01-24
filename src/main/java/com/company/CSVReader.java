package com.company;


import java.io.*;
import java.util.function.Consumer;

public class CSVReader {

    public void readHW(String filename, AbstractBalancer balancer){
        this.readFileNode(filename,balancer::addHW);
    }

    public void readVM(String filename, AbstractBalancer balancer){
        this.readFileNode(filename,balancer::addVM);
    }

    public void readFileNode(String fileName, Consumer<String> consumer) {
        String csvFile = "/home/dokole/git/kum-a3/src/main/java/"+fileName;
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();
            while ((line = br.readLine()) != null) {
                consumer.accept(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(AbstractBalancer balancer, String fileName){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("/home/dokole/git/kum-a3/src/main/java/out/"+fileName));
            bw.write("HW Name,HW CPU, HW Mem, HW Netz, VMs, VMs CPU, VMs Mem, VMs Netz");
            bw.newLine();
            for(HW hw: balancer.hws){
                String result = hw.name+","+hw.cpu+","+hw.memmory+","+hw.netz+",";
                for(VM vm : hw.vms){
                    result+=vm.name+" ";
                }
                result+=","+hw.vmsCPU()+","+ hw.vmsMemmory()+","+hw.vmsNetz();
                bw.write(result);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}