# 📊 MPAndroidChart

---

## ❓ Zakaj MPAndroidChart?

**MPAndroidChart** je odlična izbira za razvijalce, ki želijo:  
- Ustvariti interaktivne in prilagodljive grafe.  
- Hitro integrirati grafe v svoje Android aplikacije.  
- Povečati vizualno privlačnost svojih aplikacij.  
- **MPAndroidChart je različica iste knjižnice, ki je na voljo tudi za iOS pod imenom [Charts](https://github.com/ChartsOrg/Charts).**

---

## ✔️ Prednosti

-  **Enostavna uporaba:** Intuitiven API za integracijo.  
-  **Raznolikost grafikonov:** Podpora za LineChart, BarChart(horizontal/vertical), PieChart, ScatterChart, RadarChart in druge.  
-  **Interaktivnost:** Podpira povečavo, premikanje in klikanje na točke in prikaz podatkov ob prehodu (hover).  
-  **Prilagodljivost:** Možnost spreminjanja barve, velikosti, smeri in kombiniranja več vrst grafov.  
-  **Dobra dokumentacija:** Na voljo so primeri in vodniki v samem repozitoriju ter na spletu. 
-  **Široka podpora:** Deluje na vseh napravah z Android API 14+, ki vključujejo več kot 99% današnjih uporabnikov.


## ❌ Slabosti

-  **Zmogljivost:** Pri velikih količinah podatkov lahko opazimo nižjo odzivnost.  
-  **Zastarelost:** V zadnjih letih je bilo manj posodobitev, kar lahko privede do težav pri delovanju na novejših napravah.  
-  **Odvisnost od skupnosti:** Brez uradnega vzdrževanja s strani večje organizacije.  


---

## 👥 Število uporabnikov

MPAndroidChart uporablja na tisoče razvijalcev in je ena izmed najbolj priljubljenih knjižnic za grafe v Android ekosistemu.  

![img.png](app/src/main/res/drawable/mpcharts_info.png)

## 🔧 Vzdrževanje projekta

-  **Zadnja posodobitev:** Knjižnica je bila nazadnje posodobljena [septembra 2020](https://github.com/PhilJay/MPAndroidChart).  
-  **Število razvijalcev:** Android različico projekta trenutno vzdržuje 68 članov, medtem ko iOS različico vzdržuje 154 članov.  

---

## 🛡️ Licenca

**MPAndroidChart** je licencirana pod **Apache 2.0** licenco.

Več informacij najdete [tukaj](https://www.apache.org/licenses/LICENSE-2.0).  

---

## 📸 Primeri z implementacijo

### 1. Bar Chart
![Bar Chart](screenshots/BarChart.png)

**Koda:**
```kotlin
// Koda za Bar Chart
private fun setupBarChart() {
    val entries = listOf(
        BarEntry(1f, 10f),
        BarEntry(2f, 20f),
        BarEntry(3f, 30f)
    )
    val dataSet = BarDataSet(entries, "Bar Chart").apply {
        color = resources.getColor(android.R.color.holo_blue_light, theme)
    }
    val barData = BarData(dataSet)
    binding.barChart.data = barData
    binding.barChart.description.isEnabled = false
    binding.barChart.animateY(1000)
}