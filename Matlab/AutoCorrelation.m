%建立样本库的相似度（autocorrelation）矩阵，获取相似度特性
%以距离表征相似度特性，获取各自的相似度距离最小值，最大值，平均值，
%（均为欧氏距离，注意欧氏距离的算法，对样本元素先平方，再求和，然后开方）distance=sqrt(sum(c)),其中c为两个矩阵的差矩
function autoC=AutoCorrelation(sample)
X=sample(:,1:4800);
%归一化,按均值归一化,
%注意样本值不能采取同一个
%注意均值的方式要相同于KNN_test
len = size(X,1);
maxV = max(X);
minV = min(X);
range = maxV-minV;
newX = (X-repmat(minV,[len,1]))./(repmat(range,[len,1]));

%求相似度距离平均值，根据特定样本处理，需要提前知道每一个人脸的样本数目，
distanceX_1=[];
%给定样本中，单个人脸样本为5组时，距离值共有4+3+2+1=10个
for j=1:4 
    diffX=repmat(newX(j,:),[5-j,1])-newX((j+1):5,:);
    %样本之间的距离，以列向量的方式给出 
    distanceX = sqrt(sum(diffX.^2,2));
    %以列向量的方式给出，得到10维距离矩阵
    distanceX_1=[distanceX_1;distanceX];
end 
  %样本相似度矩阵
 autoC=distanceX_1';
end 
        
