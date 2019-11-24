function [] = retiradaBolasUrna(Total,N)
    xi = 1:Total;
    pX = ones(1,Total)*1/Total;    
    num=[];
    while( length(unique(num)) ~= N)
        numerosGerados = fmp(xi,pX,N);
    end
    stem(numerosGerados,ones(1,N));
end