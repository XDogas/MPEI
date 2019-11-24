function g2 = geraChave2(media,variancia,fmp)
    letras= ['A':'Z' 'a':'z'];
    length(letras);

    comprimento = max([1,floor(media+randn() * sqrt(variancia))]);
    g2 = blanks(comprimento);

    Fx = cumsum(fmp);

    for k = 1:comprimento
        U=rand();
        pos=sum(U>Fx)+1;
        g2(k)=letras(pos);
    end
end
