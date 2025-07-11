# Programmazione-Sistemi-Mobili-Aloe-Strazzella

# ParkFinder

**ParkFinder** è un'app Android che consente agli utenti di trovare parchi vicini alla loro posizione attuale, visualizzare dettagli specifici di ogni parco, le previsioni meteo locali e gestire una lista personalizzata di parchi preferiti.

---

## Caratteristiche principali

- **Visualizzazione parchi nelle vicinanze:** Ricerca di parchi entro un raggio specificato dalla posizione corrente.
- **Dettagli parco:** Visualizzazione di informazioni dettagliate per ciascun parco selezionato.
- **Previsioni meteo:** Mostra le condizioni meteo attuali per la posizione del parco selezionato.
- **Gestione preferiti:** Aggiungi e rimuovi parchi dalla lista dei preferiti, salvata localmente.
- **Interfaccia reattiva:** Aggiornamento dinamico dei dati con l’utilizzo di LiveData e ViewModel.
- **Architettura moderna:** Uso di MVVM, repository pattern e coroutine per la gestione asincrona.

---

## Tecnologie e librerie utilizzate

- Kotlin
- Android Jetpack (ViewModel, LiveData)
- Coroutine per la gestione asincrona
- Architettura MVVM (Model-View-ViewModel)
- Repository pattern per la separazione dei dati
- API di localizzazione e rete (es. Retrofit)
- Storage locale per gestione preferiti
- Material Design per UI

---

## Struttura del progetto

- **data**: Modelli di dati, repository, storage locale
- **viewmodel**: ViewModel e factory per gestione logica UI
- **ui**: Fragments/Activities e componenti UI
- **network**: Implementazioni per chiamate API esterne (es. meteo)
- **utils**: Utility e helper functions

---

## Come eseguire il progetto

1. **Clona il repository**

    ```bash
    git clone https://github.com/tuo-username/ParkFinder.git
    cd ParkFinder
    ```

2. **Apri il progetto con Android Studio**

3. **Configura le chiavi API**

    Se il progetto utilizza API esterne (per esempio meteo), assicurati di inserire le chiavi API necessarie in `local.properties` o nelle variabili di ambiente.

4. **Build e avvia l’app**

    Compila e avvia l'app su un dispositivo o emulatore Android.

---

- Email: matteoaloe3@unibo.studio.it
- Email: strazzellaelia@unibo.studio.it


