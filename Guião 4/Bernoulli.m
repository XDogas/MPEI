function y = Bernoulli( p, n )
    y = rand(n, 1) <= p;
end