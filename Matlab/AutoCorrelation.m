%��������������ƶȣ�autocorrelation�����󣬻�ȡ���ƶ�����
%�Ծ���������ƶ����ԣ���ȡ���Ե����ƶȾ�����Сֵ�����ֵ��ƽ��ֵ��
%����Ϊŷ�Ͼ��룬ע��ŷ�Ͼ�����㷨��������Ԫ����ƽ��������ͣ�Ȼ�󿪷���distance=sqrt(sum(c)),����cΪ��������Ĳ��
function autoC=AutoCorrelation(sample)
X=sample(:,1:4800);
%��һ��,����ֵ��һ��,
%ע������ֵ���ܲ�ȡͬһ��
%ע���ֵ�ķ�ʽҪ��ͬ��KNN_test
len = size(X,1);
maxV = max(X);
minV = min(X);
range = maxV-minV;
newX = (X-repmat(minV,[len,1]))./(repmat(range,[len,1]));

%�����ƶȾ���ƽ��ֵ�������ض�����������Ҫ��ǰ֪��ÿһ��������������Ŀ��
distanceX_1=[];
%���������У�������������Ϊ5��ʱ������ֵ����4+3+2+1=10��
for j=1:4 
    diffX=repmat(newX(j,:),[5-j,1])-newX((j+1):5,:);
    %����֮��ľ��룬���������ķ�ʽ���� 
    distanceX = sqrt(sum(diffX.^2,2));
    %���������ķ�ʽ�������õ�10ά�������
    distanceX_1=[distanceX_1;distanceX];
end 
  %�������ƶȾ���
 autoC=distanceX_1';
end 
        
