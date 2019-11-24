% Ex3
fc = 0.8;
nKeys = 1000;
R = nKeys/fc;
m = zeros(1,R);

for k = 1:1000
    s2h = string2hash(geraChave(3,20));
    pos = rem(s2h,R)+1;
    m(pos)= m(pos)+1;
end

figure(1)
stem(m)

figure(2)
hist(m,0:max(m))
[n,x] = hist(m,0:max(m))

% Ex4
px = n/R;

figure(3)
stem(x,px)

ValorEsperado = sum(x.*px)
Variancia = sum((x.^2).*px)-(ValorEsperado)^2