# ADR-0001: Architecture — China market-entry compliance actor (`marketentry`)

**Status**: accepted
**Date**: 2026-07-10

## Decision

Promote `cloud-itonami-iso3166-chn` from `:blueprint` to `:implemented`
by forking the JPN `marketentry` actor and swapping jurisdiction facts.

### HARD checks

1. spec-basis (CCGP / GPL G2 citations)
2. evidence-incomplete
3. **domestic-entity-missing** (FLAGSHIP) — domestic legal-entity posture for foreign capital
4. engagement-fee-mismatch
5. **uscc-unverified** (conditional) — 统一社会信用代码
6. already-drafted / already-submitted

`:filing/submit` never auto-commits at any phase.
