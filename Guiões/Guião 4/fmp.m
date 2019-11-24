function y = fmp(xi,pX,N)

    y    = rand(1, N);          
    pxcs = cumsum(pX);
    
    for i = 1:N
        a = find(pxcs > y(i));
        y(i) = xi(a(1));
    end
    
end