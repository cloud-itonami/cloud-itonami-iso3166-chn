(ns culture.facts
  "Country-level regional-culture catalog for China (CHN) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"CHN"
   [{:culture/id "chn.dish.peking-duck"
     :culture/name "Peking duck"
     :culture/name-local "北京烤鸭"
     :culture/country "CHN"
     :culture/kind :dish
     :culture/summary "Roast duck dish from Beijing prepared since the Imperial era, characterised by thin, crispy skin; by the mid-20th century it had become a national symbol of China."
     :culture/url "https://en.wikipedia.org/wiki/Peking_duck"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.dish.jiaozi"
     :culture/name "Jiaozi"
     :culture/name-local "饺子"
     :culture/country "CHN"
     :culture/kind :dish
     :culture/summary "Chinese dumplings of ground meat or vegetable filling in thinly rolled dough, with great cultural significance within China as a major Chinese New Year dish in the north."
     :culture/url "https://en.wikipedia.org/wiki/Jiaozi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.dish.hot-pot"
     :culture/name "Hot pot"
     :culture/name-local "火锅"
     :culture/country "CHN"
     :culture/kind :dish
     :culture/summary "Chinese dish of simmering broth at the table in which diners cook raw ingredients; a copper hot pot from the Three Kingdoms period (200-280 AD) is generally acknowledged as its origin."
     :culture/url "https://en.wikipedia.org/wiki/Hot_pot"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.dish.mapo-tofu"
     :culture/name "Mapo tofu"
     :culture/name-local "麻婆豆腐"
     :culture/country "CHN"
     :culture/kind :dish
     :culture/summary "Popular Chinese dish from Sichuan province of tofu in a spicy douban-based sauce with minced meat, which emerged from a Chengdu restaurant in the 1860s-1870s."
     :culture/url "https://en.wikipedia.org/wiki/Mapo_tofu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.beverage.baijiu"
     :culture/name "Baijiu"
     :culture/name-local "白酒"
     :culture/country "CHN"
     :culture/kind :beverage
     :culture/summary "Colourless Chinese distilled spirit, usually made from fermented sorghum; the world's bestselling liquor, consumed mostly in China."
     :culture/url "https://en.wikipedia.org/wiki/Baijiu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.beverage.chinese-tea"
     :culture/name "Chinese tea"
     :culture/name-local "茶"
     :culture/country "CHN"
     :culture/kind :beverage
     :culture/summary "Tea drinking originated in China and has a long history there; tea is counted among the seven necessities of Chinese life."
     :culture/url "https://en.wikipedia.org/wiki/Chinese_tea"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.craft.chinese-ceramics"
     :culture/name "Chinese ceramics"
     :culture/country "CHN"
     :culture/kind :craft
     :culture/summary "One of the most significant forms of Chinese art; porcelain was a Chinese invention, so identified with China that it is still called 'china' in everyday English."
     :culture/url "https://en.wikipedia.org/wiki/Chinese_ceramics"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.product.silk"
     :culture/name "Silk"
     :culture/name-local "丝绸"
     :culture/country "CHN"
     :culture/kind :product
     :culture/summary "Textile whose production originated in Neolithic central China; China held a virtual monopoly on silk for roughly a thousand years after the Silk Road opened."
     :culture/url "https://en.wikipedia.org/wiki/Silk"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.festival.chinese-new-year"
     :culture/name "Chinese New Year"
     :culture/name-local "春节"
     :culture/country "CHN"
     :culture/kind :festival
     :culture/summary "Spring Festival marking the new year on the traditional lunisolar Chinese calendar, one of the most important holidays in Chinese culture, celebrated through the Lantern Festival."
     :culture/url "https://en.wikipedia.org/wiki/Chinese_New_Year"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "chn.heritage.great-wall"
     :culture/name "Great Wall of China"
     :culture/name-local "长城"
     :culture/country "CHN"
     :culture/kind :heritage
     :culture/summary "Series of fortifications across historical northern China totalling about 21,196 km, a UNESCO World Heritage Site inscribed in 1987."
     :culture/url "https://en.wikipedia.org/wiki/Great_Wall_of_China"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-chn culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "CHN"))
                 " CHN entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
