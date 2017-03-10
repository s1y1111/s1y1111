function gaborArray = gaborFilterBank(u,v,m,n)

%功能：产生2维Gabor滤波器组 
% 
% 输入参数
%       u	:	滤波器尺度
%       v	:	滤波器方向
%       m	:	2维滤波器行数
%       n	:	2维滤波器列数
% 
% 输出参数
%       gaborArray: 2维滤波器组，尺度由输入参数决定
% 
%本系统采用滤波器设计如下：
% gaborArray = gaborFilterBank(5,8,40,40);
% 
% 
% 
% 


                                        %函数主体

if (nargin ~= 4)    % 检查参数
    error('There must be four input arguments (Number of scales and orientations and the 2-D size of the filter)!')
end


%% 产生Gabor滤波器组
% 产生m*n个u*v的Gabor滤波器

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
