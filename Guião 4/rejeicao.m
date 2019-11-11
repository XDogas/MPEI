function [X,Y,N] = rejeicao(a,b,N)

    X = rand(1,N) * (a - b) + a;
    Y = rand(1,N);
    
    N = Y <= 1 / (sqrt(2 * pi)) * exp(-X.^2 / 2);
    
end