# securitysystem
Semestrální práce na předmět TI

## Zabezpečení domu
Systém se bude skládat z těchto součástí:
 - čidla na dveřích a oknech, pohybová čidla v místnostech
 - klávesnice u vchodu, klávesnice uvnitř
 - časovač, který bude generovat hodinový signál (třeba jednou za sekundu)

## Vstupy systému:
 - otevření dveří, otevření okna
 - zavření dveří, zavření okna
 - pohyb v místnosti (pokud se v místnosti něco hýbe, bude signál přicházet opakovaně, třeba každou sekundu)
 - časovač, který bude generovat hodinový signál (třeba jednou za sekundu)
 - mačkání čísel na klávesnici

Zabezpečovací systém by pak mohl fungovat například takto:
 - výchozí stav bude vypnuto
 - systém může někdo zapnout; pokud nejsou zavřená okna, systém na to upozorní (blikání, pípání, ne alarm)
 - zavřením dveří se systém uvede do stavu zapnuto
 - otevře-li někdo okno nebo dveře, spustí se alarm
 - bude-li pohybové čidlo hlásit pohyb nepřetržitě alespoň 5 sekund, spustí se alarm
 - když někdo zadá správný kód na klávesnici u vchodu, otevřou se dveře (nespustí se alarm)
 - bude-li kód třikrát po sobě špatně, klávesnice se na minutu odpojí
 - po otevření dveří systém čeká na zadání kódu na klávesnici uvnitř
 - zadáním správného kódu se systém vypne; byl-li spuštěn alarm, vypne se také
 - pokud kód nikdo nezadá do jedné minuty nebo bude kód zadán třikrát po sobě špatně, spustí se alarm

Detaily řešení:
-  Čidla na oknech můžete uvažovat jako jedno – prostě je otevřené nějaké okno, je jedno jaké. Zrovna tak pohybový snímač bude hlásit pohyb kdekoliv v domě.
-  Kódy na obou klávesnicích mohou být pevně nastavená trojciferná čísla.
-  Zejména pro počítání časových intervalů bude vhodné použít pomocné stavové proměnné.
-  Spuštění alarmu může být řešeno přechodem do příslušného stavu, nebo nastavením pomocné stavové proměnné (třeba na hodnotu větší než 10).
