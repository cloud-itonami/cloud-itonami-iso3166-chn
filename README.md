# cloud-itonami-iso3166-chn

Open ISO 3166 Blueprint for **CHN**: People's Republic of China — **`:implemented`**.

Independent public-sector market-entry & procurement-compliance service
for an already-incorporated operator entering Chinese public contracts
(CCGP / Government Procurement Law / USCC / domestic-entity posture).

## Implementation (R0)

| Piece | Location |
|---|---|
| Actor | `src/marketentry/*` |
| Governor | `:market-entry-compliance-governor` |
| Flagship HARD | `domestic-entity-missing` |
| Tests | `clojure -M:dev:test` |
| Demo | `clojure -M:dev:run` |

## What this is NOT

- **Not the government of China.** Commercial market-entry compliance only.

## License

AGPL-3.0-or-later.
