function gaborArray = gaborFilterBank(u,v,m,n)

%���ܣ�����2άGabor�˲����� 
% 
% �������
%       u	:	�˲����߶�
%       v	:	�˲�������
%       m	:	2ά�˲�������
%       n	:	2ά�˲�������
% 
% �������
%       gaborArray: 2ά�˲����飬�߶��������������
% 
%��ϵͳ�����˲���������£�
% gaborArray = gaborFilterBank(5,8,40,40);
% 
% 
% 
% 


                                        %��������

if (nargin ~= 4)    % ������
    error('There must be four input arguments (Number of scales and orientations and the 2-D size of the filter)!')
end


%% ����Gabor�˲�����
% ����m*n��u*v��Gabor�˲���

gaborArray = cell(u,v);
fmax = 0.25;
gama = sqrt(2);
eta = sqrt(2);

for i = 1:u
    
    fu = fmax/((sqrt(2))^(i-1));
    alpha = fu/gama;
    beta = fu/eta;
    
    for j = 1:v
        tetav = ((j-1)/v)*pi;
        gFilter = zeros(m,n);
        
        for x = 1:m
            for y = 1:n
                xprime = (x-((m+1)/2))*cos(tetav)+(y-((n+1)/2))*sin(tetav);
                yprime = -(x-((m+1)/2))*sin(tetav)+(y-((n+1)/2))*cos(tetav);
                gFilter(x,y) = (fu^2/(pi*gama*eta))*exp(-((alpha^2)*(xprime^2)+(beta^2)*(yprime^2)))*exp(1i*2*pi*fu*xprime);
            end
        end
        gaborArray{i,j} = gFilter;
        
    end
end

end
