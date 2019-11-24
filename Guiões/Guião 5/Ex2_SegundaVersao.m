letras= ['A':'Z' 'a':'z'];
ficheiros={'pg21209.txt', 'pg26017.txt'};

fmpPT = pmfLetrasPT(ficheiros,letras);

fc=0.8;
nKeys=1000;
R=nKeys/fc;
Ar= zeros(1,R);

media=10;
variancia=5;

for k= 1:1000
    temp=string2hash(geraChave2(media,variancia,fmpPT));
    pos= rem(temp,R)+1;
    Ar(pos)= Ar(pos)+1;
end

figure(1)
stem(Ar)
figure(2)
hist(Ar,0:max(Ar))
[n,x]= hist(Ar,0:max(Ar))

px= n/R;
figure(3)
stem(x,px)

valorEsperado= sum(x.*px)
variancia= sum((x.^2).*px)-(valorEsperado)^2