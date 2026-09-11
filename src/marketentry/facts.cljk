(ns marketentry.facts
  "Per-jurisdiction public-procurement market-entry regulatory catalog
  for the China market-entry actor. G2-style spec-basis table.

  Surface: China Government Procurement Network (中国政府采购网, CCGP /
  ccgp.gov.cn) operated by the Ministry of Finance; domestic legal-entity
  posture for foreign operators (WFOE/JV/representative office); Unified
  Social Credit Code (统一社会信用代码) via SAMR; Government Procurement
  Law domestic-product preference rules. Coverage reported HONESTLY.")

(def catalog
  {"CHN" {:name "People's Republic of China"
          :owner-authority "Ministry of Finance / China Government Procurement Network (CCGP)"
          :legal-basis "Government Procurement Law of the PRC; CCGP supplier publication rules"
          :national-spec "CCGP (ccgp.gov.cn) notice + supplier registration / domestic-entity posture"
          :provenance "https://www.ccgp.gov.cn/"
          :required-evidence ["统一社会信用代码确认记录 (USCC record)"
                              "CCGP 供应商相关登记记录 (CCGP supplier record)"
                              "营业执照/主体资格记录 (business-license record)"
                              "中国法人主体确认記録 (domestic-entity record)"]
          :rep-owner-authority "State Administration for Market Regulation (SAMR) / MOF"
          :rep-legal-basis "domestic legal-entity requirement for most government-procurement participation by foreign capital"
          :rep-provenance "https://www.ccgp.gov.cn/"
          :corporate-number-owner-authority "State Administration for Market Regulation (SAMR)"
          :corporate-number-legal-basis "统一社会信用代码 (Unified Social Credit Code)"
          :corporate-number-provenance "https://www.gsxt.gov.cn/"}})

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
      :note (str "cloud-itonami-iso3166-chn R0: " (count catalog)
                 " jurisdictions seeded. Extend catalog, never fabricate.")})))

(defn required-evidence-satisfied?
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3]
  (:required-evidence (spec-basis iso3) []))

(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))

(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority
                       :corporate-number-legal-basis
                       :corporate-number-provenance]))))
