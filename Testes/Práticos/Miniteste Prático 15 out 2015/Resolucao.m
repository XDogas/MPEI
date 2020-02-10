%% Ex2
% a)
fprintf("2.a)\n")
T = [0.84	0.1	0	0.5;
     0.1	0.7	0	0.1;
     0.05	0.1	0.8	0.1;
     0.01   0.1 0.2 0.3];
 
 TA_i = 1;
 TB_i = 2;
 TC_i = 10;
 TD_i = 5;
 TT = TA_i + TB_i + TC_i + TD_i;
 
 x0 = [TA_i/TT TB_i/TT TC_i/TT TD_i/TT]';
 x7 = T^7*x0;
 
 TA_f = x7(1)*TT
 TB_f = x7(2)*TT
 TC_f = x7(3)*TT
 TD_f = x7(4)*TT
 
 TT_f = TB_f + TC_f + TA_f + TD_f; % verificação, tem de dar 18
 
 % b)
 fprintf("2.b)\n")
 
 TA_max = 0;
 i = 0;
 while 1
     xi = T^i*x0;
     TA_em_i = xi(1)*TT;     
     if TA_em_i >= TA_max
         TA_max = TA_em_i;
     else
         break;
     end
     i = i+1;
 end
 TA_max
 
 TB_max = 0;
 i = 0;
 while 1
     xi = T^i*x0;
     TB_em_i = xi(2)*TT;     
     if TB_em_i >= TB_max
         TB_max = TB_em_i;
     else
         break;
     end
     i = i+1;
 end
 TB_max
 
 TC_max = 0;
 i = 0;
 while 1
     xi = T^i*x0;
     TC_em_i = xi(3)*TT;     
     if TC_em_i >= TC_max
         TC_max = TC_em_i;
     else
         break;
     end
     i = i+1;
 end
 TC_max
 
 TD_max = 0;
 i = 0;
 while 1
     xi = T^i*x0;
     TD_em_i = xi(4)*TT;     
     if TD_em_i >= TD_max
         TD_max = TD_em_i;
     else
         break;
     end
     i = i+1;
 end
 TD_max
 
 % c)
 fprintf("2.c)\n")
 
 mes = 1;
 while 1
     xi = T^mes*x0;
     if xi(4)*TT < 2
         break;
     end
     mes = mes+1;
 end
 mes
     