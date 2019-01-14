# Metaeuristici
Cerinta:
Un robot trebuie sa asambleze niste piese intr-un dispozitiv, intr-o ordine care sa respecte relatiile de precedenta obligatprii, cunoscute. Sa se realizeze o secventiere optima a asamblarii pieselor.

Ex:

1   (3) 5 - 5 = 0 ===>       a
2   (4) 5                   b
3   (-) 0
4   (1,6,8) 15  
5   (4,6)
6   (3)
7   (2,4,5)
8   (3) 
9   (2,5)
10  (5,7,9)

Ex sol: 3 6 1 8 4 2 5 9 7 10

Incerc sa folosesc Hill-Climb cu pornire aleatoare, dar nu sunt sigur daca am facut cum trebuie metodele sau nu.

Programul deocamdata genereaza o solutie "solutieIntermed1". Pentru a determina costul solutiei se face referinta la lista "referinte". 
Ulterior o sa ii dau sa faca generarea aleatoare, dar mai intai am vrut sa vad daca merge si mi se pare ok.

Algoritmul trebuie sa ruleze 3 secunde dupa sa afiseze ce solutie a gasit.(sper sa fie cea ideala in care are costul = 0 dar nu am sperante mari). 

4 7 5 8 9 10 1 3 2 6 ==>15 + 10 + 5 + ...
2 7 5 8 9 10 1 3 4 6

4 3 8 6 7 2 1 10 9 5 

4 = 15
3 = 0
8 = 0
6 = 0
7 = 10
2 = 0
1 = 0
10 = 10
9 = 5
5 = 0


3 = 0
7 = 15
6 = 0
10 = 10
8 = 0
4 = 5
2 = 0
1 = 0
5 = 0
9 = 0
