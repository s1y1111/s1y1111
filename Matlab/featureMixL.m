%函数注释见featureMixR
function [resultInfoL,imgL]=featureMixL(imgL,i,j,str)
%imgL:输入左侧面图像矩阵

%%
%----------------------------------------------------------采集样本---------------------------------------

%人脸检测
[~,img,label,imgL]=faceDet(imgL);
if(label~=1) %检测失败
    %返回失败标志信息
    resultInfoL=0;
end 
if(label==1)%检测成功
    %返回成功标志信息
    resultInfoL=1;
    %特征提取
    featureF=featureVectorsCreat_sample(img);
    
%%
%--------------------------------------------------------------更新样本------------------------------------------
if((i==1)&&(j==1))
    sampleL=featureF;
    save('D:\database\data\sampleL.mat','sampleL');
else 
    sample_oldL=load('D:\database\data\sampleL.mat');
    sample_oldL=sample_oldL.sampleL;
    sample_oldL((i-1)*5+j,:)=featureF;
    sampleL=sample_oldL;
    save('D:\database\data\sampleL.mat','sampleL');
end


end 
%%
%--------------------------------------------------------计算样本相似度矩阵-----------------------------
%样本采集完毕,
if(j==5)
    sampleL=load('D:\database\data\sampleL.mat');
    sampleL=sampleL.sampleL;
    autoCL=AutoCorrelation(sampleL);
    
    %设定样本标签并且更新autoC
    if(i~=1)
        sampleInfo_oldL=load('D:\database\data\sampleInfoL.mat');
        sampleInfo_oldL=sampleInfo_oldL.sampleInfoL;
        sampleInfo_oldL{i}=str;
        sampleInfoL=sampleInfo_oldL;
        save('D:\database\data\sampleInfoL.mat','sampleInfoL');
        %-------------------------------------------------------
        autoC_oldL=load('D:\database\data\autoCL.mat');
        autoC_oldL=autoC_oldL.autoCL;
        autoC_updateL=[autoC_oldL(1:(i-1),:);autoCL];
        autoCL=autoC_updateL;
        save('D:\database\data\autoCL.mat','autoCL');
    end 
    if(i==1)
        sampleInfoL{i}=str;
        save('D:\database\data\sampleInfoL.mat','sampleInfoL');
        %--------------------------------------------------
        save('D:\database\data\autoCL.mat','autoCL');
    end 
end 

end 