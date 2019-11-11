function y = binomial(n,p,N)
    Bern = rand(n,N) <= p;
    y = sum(Bern);
end
