%%采集样本信息
%建立正面样本采集函数
%更新样本特征

function [resultInfo,featureF,box,imgF]=featureFace(imgFace,i,j,str)
%输入参数：
%   imgFace:输入正面图像
%   i：该样本属于第i类采集样本
%   j：第i类样本的地j次采集，目前取j=5
%   str:样本标签信息
%输出参数：
%   resultInfo:特征提取成功标志
%   featureF：特征向量
%   box:正面人脸区域
%   imgF：人脸检测处理后的图像


%%
%----------------------------------------------------------采集样本---------------------------------------

%人脸检测
[box,img,label,imgF]=faceDet(imgFace);
if(label~=1) %检测失败
    %返回失败标志信息
    resultInfo=0;
    %特征矩阵置0
    featureF=[];
   %退出函数
    return 
end 
if(label==1)%检测成功
    %返回成功标志信息
    resultInfo=1;
    %特征提取
    featureF=featureVectorsCreat_sample(img);
    
%%
%--------------------------------------------------------------更新样本------------------------------------------
if((i==1)&&(j==1))
    sample=featureF;
    save('D:\database\data\sample.mat','sample');
else 
   sample_old=load('D:\database\data\sample.mat');
   sample_old=sample_old.sample;
   sample_old(((i-1)*5+j),:)=featureF;
   sample=sample_old;
   save('D:\database\data\sample.mat','sample');
end

end
%%
%--------------------------------------------------------计算样本相似度矩阵-----------------------------
%样本采集完毕,
if(j==5)
    sample=load('D:\database\data\sample.mat');
    sample=sample.sample;
    sample=sample(((i-1)*5+1):((i-1)*5+5),:);
    autoC=AutoCorrelation(sample);
    
    
  
     if(i~=1)
        sampleInfo_old=load('D:\database\data\sampleInfo.mat');
        sampleInfo_old=sampleInfo_old.sampleInfo;
        sampleInfo_old{i}=str;
        sampleInfo=sampleInfo_old;
        save('D:\database\data\sampleInfo.mat','sampleInfo');
        %-------------------------------------------------------
        autoC_old=load('D:\database\data\autoC.mat');
        autoC_old=autoC_old.autoC;
        autoC_update=[autoC_old(1:(i-1),:);autoC];
        autoC=autoC_update;
        save('D:\database\data\autoC.mat','autoC');
    end
   if(i==1)
        sampleInfo{i}=str;
        save('D:\database\data\sampleInfo.mat','sampleInfo');
        %--------------------------------------------------
        save('D:\database\data\autoC.mat','autoC');
    end 
end 


end 



