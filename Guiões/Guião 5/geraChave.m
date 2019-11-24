function chave = geraChave(min, max)    
    letters = ['a':'z' 'A':'Z'];
    length = randi([min max]);
    chave = letters(randi(numel(letters), length, 1))    
end