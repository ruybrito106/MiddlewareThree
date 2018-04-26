package com.company.distribution.naming;

import com.company.distribution.ClientProxy;

import java.util.ArrayList;

public class NamingRepository {

    private ArrayList<NamingRecord> namingRecord = new ArrayList<NamingRecord>();

    public NamingRepository() {
        this.namingRecord = new ArrayList<NamingRecord>();
    }

    public ArrayList<NamingRecord> getNamingRecord() {
        return namingRecord;
    }

    public void setNamingRecord(ArrayList<NamingRecord> namingRecord) {
        this.namingRecord = namingRecord;
    }

    public void addService(String serviceName, ClientProxy proxy) {
        this.namingRecord.add(new NamingRecord(serviceName, proxy));
    }

    public ClientProxy getService(String serviceName) {
        for (int i = 0; i < namingRecord.size(); i++) {
            if (namingRecord.get(i).getServiceName().equals(serviceName)) {
                return (ClientProxy) namingRecord.get(i).getClientProxy();
            }
        }
        return null;
    }

    public ArrayList<String> getServices() {
        ArrayList<String> services = new ArrayList<String>();
        for (int i = 0; i < namingRecord.size(); i++) {
            services.add(namingRecord.get(i).getServiceName());
        }
        return services;
    }

}
