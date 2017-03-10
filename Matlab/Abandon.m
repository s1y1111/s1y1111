function Abandon(i)
%数据库还原函数，录入过程中，取消录入时执行此函数，还原数据库
if(i==1)
    autoC=[];
    autoCL=[];
    autoCR=[];
    sample=[];
    sampleL=[];
    sampleR=[];
    sampleInfo={};
    sampleInfoL={};
    sampleInfoR={};
    
    save('D:\database\data\autoC.mat','autoC');
    save('D:\database\data\autoCL.mat','autoCL');
    save('D:\database\data\autoCR.mat','autoCR');
    save('D:\database\data\sample.mat','sample');
    save('D:\database\data\sampleL.mat','sampleL');
    save('D:\database\data\sampleR.mat','sampleR');
    save('D:\database\data\sampleInfo.mat','sampleInfo');
    save('D:\database\data\sampleInfoL.mat','sampleInfoL');
    save('D:\database\data\sampleInfoR.mat','sampleInfoR');
else
    autoC=load('D:\database\data\autoC.mat');
    autoC=autoC.autoC;
    autoCL=load('D:\database\data\autoCL.mat');
    autoCL=autoCL.autoCL;
    autoCR=load('D:\database\data\autoCR.mat');
    autoCR=autoCR.autoCR;
    sample=load('D:\database\data\sample.mat');
    sample=sample.sample;
    sampleL=load('D:\database\data\sampleL.mat');
    sampleL=sampleL.sampleL;
    sampleR=load('D:\database\data\sampleR.mat');
    sampleR=sampleR.sampleR;
    sampleInfo=load('D:\database\data\sampleInfo.mat');
    sampleInfo=sampleInfo.sampleInfo;
    sampleInfoL=load('D:\database\data\sampleInfoL.mat');
    sampleInfoL=sampleInfoL.sampleInfoL;
    sampleInfoR=load('D:\database\data\sampleInfoR.mat');
    sampleInfoR=sampleInfoR.sampleInfoR;
    
    autoC=autoC(1:(i-1),:);
    autoCL=autoCL(1:(i-1),:);
    autoCR=autoCR(1:(i-1),:);
    
    sample=sample(1:(i-1)*5,:);
    sampleL=sampleL(1:(i-1)*5,:);
    sampleR=sampleR(1:(i-1)*5,:);
    
    sampleInfo=sampleInfo(1:(i-1));
    sampleInfoL=sampleInfoL(1:(i-1));
    sampleInfoR=sampleInfoR(1:(i-1));
    
    
    save('D:\database\data\autoC.mat','autoC');
    save('D:\database\data\autoCL.mat','autoCL');
    save('D:\database\data\autoCR.mat','autoCR');
    
    save('D:\database\data\sample.mat','sample');
    save('D:\database\data\sampleL.mat','sampleL');
    save('D:\database\data\sampleR.mat','sampleR');
    
    save('D:\database\data\sampleInfo.mat','sampleInfo');
    save('D:\database\data\sampleInfoL.mat','sampleInfoL');
    save('D:\database\data\sampleInfoR.mat','sampleInfoR');
end 
end 