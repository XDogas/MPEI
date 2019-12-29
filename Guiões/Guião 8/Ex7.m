T = [0.8 0.1 0.05; 0.2 0.6 0.2; 0 0.3 0.75];

% a)
fprintf("7.a)\n")
dinheiroAna = 100;
dinheiroBernardo = 200;
dinheiroCatarina = 30;
dinheiroTotal = dinheiroAna + dinheiroBernardo + dinheiroCatarina;
x0 = [100/dinheiroTotal 200/dinheiroTotal 30/dinheiroTotal]';
x3 = T^3*x0;
dinheiroAna_Dia4 = x3(1)*dinheiroTotal
dinheiroBernardo_Dia4 = x3(2)*dinheiroTotal
dinheiroCatarina_Dia4 = x3(3)*dinheiroTotal

% b)
fprintf("7.b)\n")
x365 = T^365*x0;
dinheiroAna_Apos1Ano = x365(1)*dinheiroTotal
dinheiroBernardo_Apos1Ano = x365(2)*dinheiroTotal
dinheiroCatarina_Apos1Ano = x365(3)*dinheiroTotal

% c)
fprintf("7.c)\n")
dia = 1;
while 1
  xi = T^dia*x0;
  if xi(3)*dinheiroTotal > 130
    break;
  end
  dia = dia+1;
end
fprintf("A Catarina passa a ter mais de 130 euros no dia %d de janeiro.\n", dia);