%%
%样本采集程序
%i:当前录入的人属于第几个
%j:当前录入的人的第几次图像


function resultInfo=mainSample(i,j,str)
%%
%函数用法:
%   调用函数，对输入图像进行特征提取，返回提取结果。
%输入参数：
%   i:当前采集样本人数
%   j:当前样本采集的次数
%   str:当前样本姓名
%输参数：
%   resultInfo：录入成功标志


%读入采集图像
imgL=imread('D:\database\picturesGet\left.jpg');
imgFace=imread('D:\database\picturesGet\center.jpg');
imgR=imread('D:\database\picturesGet\right.jpg');
%}

%%
[resultInfof,~,~,imgF]=featureFace(imgFace,i,j,str);
if(resultInfof==1)
    [resultInfol,imgL]=featureMixL(imgL,i,j,str);
        if(resultInfol==1)
        [resultInfor,imgR]=featureMixR(imgR,i,j,str);
        resultInfo=resultInfor;
        else resultInfo=resultInfol;
        end
else resultInfo=resultInfof;    
end     
%写入采集处理后的图片
%若不需要保存处理图像请注释以下代码
%---------------------------------------
if(resultInfo==1)
    f=strcat('D:\database\pictures\',num2str(i),'.',num2str(j),'center.jpg');
    l=strcat('D:\database\pictures\',num2str(i),'.',num2str(j),'left.jpg');
    r=strcat('D:\database\pictures\',num2str(i),'.',num2str(j),'right.jpg');
    imwrite(imgF,f);
    imwrite(imgL,l);
    imwrite(imgR,r);
end 
%--------------------------------------------------
end 