# Changelog

## 0.1.0-alpha.10 (2025-01-28)

Full Changelog: [v0.1.0-alpha.9...v0.1.0-alpha.10](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.9...v0.1.0-alpha.10)

### ⚠ BREAKING CHANGES

* **client:** better union variant method and variable names ([#82](https://github.com/anthropics/anthropic-sdk-java/issues/82))

### Features

* **api:** add citations ([#78](https://github.com/anthropics/anthropic-sdk-java/issues/78)) ([f206f8a](https://github.com/anthropics/anthropic-sdk-java/commit/f206f8a2b3334714f8dfde4d4a4fc602a8233272))
* **client:** add `close` method ([#87](https://github.com/anthropics/anthropic-sdk-java/issues/87)) ([2ef94d1](https://github.com/anthropics/anthropic-sdk-java/commit/2ef94d196ba402fd7af3db48aed98e7f57afca90))
* **client:** better union variant method and variable names ([#82](https://github.com/anthropics/anthropic-sdk-java/issues/82)) ([f961513](https://github.com/anthropics/anthropic-sdk-java/commit/f9615133f292297ce37019cfb2db40b08c3e4c39))


### Bug Fixes

* **client:** async streaming flakiness ([#85](https://github.com/anthropics/anthropic-sdk-java/issues/85)) ([fbc58f3](https://github.com/anthropics/anthropic-sdk-java/commit/fbc58f3931c1d11f16cd1095818d13c7e8f47e28))
* **client:** make some classes and constructors non-public ([#90](https://github.com/anthropics/anthropic-sdk-java/issues/90)) ([803559d](https://github.com/anthropics/anthropic-sdk-java/commit/803559d4b43e90543f700080d768a81a831aa9b8))
* examples ([0a7cd8c](https://github.com/anthropics/anthropic-sdk-java/commit/0a7cd8c951078ecbee42c71b84ea0b03b33c6fd7))


### Chores

* add max retries to test ([#83](https://github.com/anthropics/anthropic-sdk-java/issues/83)) ([8b96530](https://github.com/anthropics/anthropic-sdk-java/commit/8b96530c976f3ebdc48c7832e1cab7a6b9e98c99))
* **api:** deprecate some models ([#93](https://github.com/anthropics/anthropic-sdk-java/issues/93)) ([e88f509](https://github.com/anthropics/anthropic-sdk-java/commit/e88f509fbe355f54053efb516b00fe8ce5438deb))
* **docs:** updates ([#81](https://github.com/anthropics/anthropic-sdk-java/issues/81)) ([1c064b5](https://github.com/anthropics/anthropic-sdk-java/commit/1c064b5fdd4e5c8708f7c50a8d1a1737f9b55704))
* **internal:** fix release ([#86](https://github.com/anthropics/anthropic-sdk-java/issues/86)) ([122923d](https://github.com/anthropics/anthropic-sdk-java/commit/122923d1a3006b052966d0ba5226a1a7091f9174))
* **internal:** remove some unnecessary `constructor` keywords ([803559d](https://github.com/anthropics/anthropic-sdk-java/commit/803559d4b43e90543f700080d768a81a831aa9b8))
* **internal:** shorten `model` method impl ([#92](https://github.com/anthropics/anthropic-sdk-java/issues/92)) ([10c45b2](https://github.com/anthropics/anthropic-sdk-java/commit/10c45b28377ac8ebb84f474c09792b031056bf6d))
* **internal:** swap `checkNotNull` to `checkRequired` ([#80](https://github.com/anthropics/anthropic-sdk-java/issues/80)) ([7bc70d7](https://github.com/anthropics/anthropic-sdk-java/commit/7bc70d70d4900dd481300a9fdce2b7c95d23150e))


### Documentation

* `async` and `sync` method comments ([#89](https://github.com/anthropics/anthropic-sdk-java/issues/89)) ([b7dbed7](https://github.com/anthropics/anthropic-sdk-java/commit/b7dbed7759c78c9bd9ba6b660afe5718b995e5a0))
* add client documentation ([#88](https://github.com/anthropics/anthropic-sdk-java/issues/88)) ([ac678e4](https://github.com/anthropics/anthropic-sdk-java/commit/ac678e4e238b634faed95a9e52018a5443d9e29b))
* builder, enum, and union comments ([#91](https://github.com/anthropics/anthropic-sdk-java/issues/91)) ([e8ad558](https://github.com/anthropics/anthropic-sdk-java/commit/e8ad558347d04ffea57863568453fb824289ca82))
* many more examples ([#84](https://github.com/anthropics/anthropic-sdk-java/issues/84)) ([52f73db](https://github.com/anthropics/anthropic-sdk-java/commit/52f73dbe747e42ea9dda87283db7073d2a59570e))

## 0.1.0-alpha.9 (2025-01-22)

Full Changelog: [v0.1.0-alpha.8...v0.1.0-alpha.9](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.8...v0.1.0-alpha.9)

### Features

* **client:** make message roundtripping more robust ([#75](https://github.com/anthropics/anthropic-sdk-java/issues/75)) ([3153b8b](https://github.com/anthropics/anthropic-sdk-java/commit/3153b8b4512d8e97daa3a80907c8c246dbf6778c))
* **client:** support results endpoint ([#73](https://github.com/anthropics/anthropic-sdk-java/issues/73)) ([361a2d2](https://github.com/anthropics/anthropic-sdk-java/commit/361a2d21e12329600447b0703fa5a863ab725d1f))


### Bug Fixes

* **client:** add missing default headers ([#72](https://github.com/anthropics/anthropic-sdk-java/issues/72)) ([4bfb8c5](https://github.com/anthropics/anthropic-sdk-java/commit/4bfb8c5bc3f2d7372243d727937bec1cedd468df))
* **client:** make service impl constructors internal ([#70](https://github.com/anthropics/anthropic-sdk-java/issues/70)) ([77f8873](https://github.com/anthropics/anthropic-sdk-java/commit/77f88730bd9066a91d667f9a432beef9e47b0e9e))


### Chores

* **internal:** add file comment ([#74](https://github.com/anthropics/anthropic-sdk-java/issues/74)) ([70def92](https://github.com/anthropics/anthropic-sdk-java/commit/70def920ea6c7e358f9b464411417408770ac627))
* **internal:** move `StreamResponse` method ([#65](https://github.com/anthropics/anthropic-sdk-java/issues/65)) ([083a7b5](https://github.com/anthropics/anthropic-sdk-java/commit/083a7b5746329527eac1d12fbe6e10a6ca522035))
* **internal:** refactor streaming implementation ([#64](https://github.com/anthropics/anthropic-sdk-java/issues/64)) ([02dcd90](https://github.com/anthropics/anthropic-sdk-java/commit/02dcd9031064cfd7e7a6a9fc25b14d7b3adddc78))
* **internal:** remove space ([#63](https://github.com/anthropics/anthropic-sdk-java/issues/63)) ([b3a86b3](https://github.com/anthropics/anthropic-sdk-java/commit/b3a86b36ff3c4c7135931125a0958e960986ada8))
* **internal:** upgrade kotlin compiler and gradle ([#66](https://github.com/anthropics/anthropic-sdk-java/issues/66)) ([8685797](https://github.com/anthropics/anthropic-sdk-java/commit/86857974a752405318ca92fe4d593af757742743))


### Documentation

* add javadoc.io badge ([#68](https://github.com/anthropics/anthropic-sdk-java/issues/68)) ([9853408](https://github.com/anthropics/anthropic-sdk-java/commit/98534089861eb8f3bbd78863bcbc1ed69bcf80dc))
* add more documentation ([#67](https://github.com/anthropics/anthropic-sdk-java/issues/67)) ([c179f7c](https://github.com/anthropics/anthropic-sdk-java/commit/c179f7cf2648d8df5d110df8e2cee2e658d1a739))
* generate merged core + okhttp docs ([#61](https://github.com/anthropics/anthropic-sdk-java/issues/61)) ([c2802d1](https://github.com/anthropics/anthropic-sdk-java/commit/c2802d114cf04ebf49d9d3988c094732f9ab5d3f))
* more enum documentation ([#71](https://github.com/anthropics/anthropic-sdk-java/issues/71)) ([21c6ef2](https://github.com/anthropics/anthropic-sdk-java/commit/21c6ef237d88a506915eb7cb0eb4a79d6b603528))
* move up requirements section ([#77](https://github.com/anthropics/anthropic-sdk-java/issues/77)) ([a3243cb](https://github.com/anthropics/anthropic-sdk-java/commit/a3243cb562af8897792c0d3e51327d6f7230605f))
* update readme ([#76](https://github.com/anthropics/anthropic-sdk-java/issues/76)) ([fe53290](https://github.com/anthropics/anthropic-sdk-java/commit/fe5329055b49ef2dcd57bb4b307ec0614c538551))

## 0.1.0-alpha.8 (2025-01-15)

Full Changelog: [v0.1.0-alpha.7...v0.1.0-alpha.8](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.7...v0.1.0-alpha.8)

### Chores

* **internal:** add and tweak check functions ([#55](https://github.com/anthropics/anthropic-sdk-java/issues/55)) ([16f8002](https://github.com/anthropics/anthropic-sdk-java/commit/16f80028849f54f8feab7314e33d557e4a923581))
* **internal:** remove unused gradle task ([#60](https://github.com/anthropics/anthropic-sdk-java/issues/60)) ([f503120](https://github.com/anthropics/anthropic-sdk-java/commit/f50312015016e33fefb08a07365d01bf9e11d07d))
* **internal:** tweak client options nullability handling ([16f8002](https://github.com/anthropics/anthropic-sdk-java/commit/16f80028849f54f8feab7314e33d557e4a923581))
* simplify examples involving lists ([#57](https://github.com/anthropics/anthropic-sdk-java/issues/57)) ([b9f1145](https://github.com/anthropics/anthropic-sdk-java/commit/b9f114543501938c386f659417e312844900dd56))
* simplify examples involving unions ([#58](https://github.com/anthropics/anthropic-sdk-java/issues/58)) ([e800907](https://github.com/anthropics/anthropic-sdk-java/commit/e800907343dfa88baf644eafa3953098072fcda0))


### Documentation

* don't mention a non-existent SDK ([#59](https://github.com/anthropics/anthropic-sdk-java/issues/59)) ([421a9ab](https://github.com/anthropics/anthropic-sdk-java/commit/421a9ab64779d1bb34fb10cd7ad014defe2660df))

## 0.1.0-alpha.7 (2025-01-14)

Full Changelog: [v0.1.0-alpha.6...v0.1.0-alpha.7](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.6...v0.1.0-alpha.7)

### ⚠ BREAKING CHANGES

* **client:** switch query params objects to use `QueryParams` ([#31](https://github.com/anthropics/anthropic-sdk-java/issues/31))

### Features

* **api:** add message batch delete endpoint ([#29](https://github.com/anthropics/anthropic-sdk-java/issues/29)) ([4cfead7](https://github.com/anthropics/anthropic-sdk-java/commit/4cfead7e723bf66c870ed2bc13d1f7778e572de9))
* **client:** add more builder convenience methods for lists ([#46](https://github.com/anthropics/anthropic-sdk-java/issues/46)) ([40210f9](https://github.com/anthropics/anthropic-sdk-java/commit/40210f90ff6c1c700042efdbe2649921c061bd78))
* **client:** add various convenience setters to models ([#44](https://github.com/anthropics/anthropic-sdk-java/issues/44)) ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **client:** allow passing null or optional for nullable fields ([#40](https://github.com/anthropics/anthropic-sdk-java/issues/40)) ([f1594bf](https://github.com/anthropics/anthropic-sdk-java/commit/f1594bf97bfcba21ae6258622f15b1d1db8a07b3))
* **client:** allow setting arbitrary JSON for top-level body params ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **client:** expose getters for `JsonField` of body params ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **client:** put body field in params, add more convenience methods, and add missing docs ([#37](https://github.com/anthropics/anthropic-sdk-java/issues/37)) ([bc9974b](https://github.com/anthropics/anthropic-sdk-java/commit/bc9974b330f8f6032a69a984f9d59b15e7c43af6))


### Bug Fixes

* **client:** add some missing `validate()` calls ([#49](https://github.com/anthropics/anthropic-sdk-java/issues/49)) ([3030d05](https://github.com/anthropics/anthropic-sdk-java/commit/3030d057d53c7dd5dfd7c566204876e0903ff1bb))
* **client:** consistently throw on omitting required fields ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **client:** convert `JsonField` containing list type to mutable in builder ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))


### Chores

* **internal:** add some missing newlines between methods ([#48](https://github.com/anthropics/anthropic-sdk-java/issues/48)) ([67e7461](https://github.com/anthropics/anthropic-sdk-java/commit/67e74612794995bf05acce426224752d03466455))
* **internal:** extract a `checkRequired` function ([#54](https://github.com/anthropics/anthropic-sdk-java/issues/54)) ([1562284](https://github.com/anthropics/anthropic-sdk-java/commit/1562284ae76888974318e1623fceee61ae3f2880))
* **internal:** fix up root `build.gradle.kts` formatting ([#50](https://github.com/anthropics/anthropic-sdk-java/issues/50)) ([b766f44](https://github.com/anthropics/anthropic-sdk-java/commit/b766f44dfaa6b7c67cd6ed620cd6db4256de8edd))
* **internal:** refactor `validate` methods ([3030d05](https://github.com/anthropics/anthropic-sdk-java/commit/3030d057d53c7dd5dfd7c566204876e0903ff1bb))
* **internal:** remove unused Gradle imports ([#51](https://github.com/anthropics/anthropic-sdk-java/issues/51)) ([acd68e0](https://github.com/anthropics/anthropic-sdk-java/commit/acd68e0e9fcfc99232ac53f709965b0d1bb4f2f0))
* **internal:** remove unused or unnecessary Gradle imports ([#52](https://github.com/anthropics/anthropic-sdk-java/issues/52)) ([5c2320d](https://github.com/anthropics/anthropic-sdk-java/commit/5c2320dfd370d3952e11ee8382e9f860e54b7bca))
* **internal:** update examples ([#41](https://github.com/anthropics/anthropic-sdk-java/issues/41)) ([8dc8b63](https://github.com/anthropics/anthropic-sdk-java/commit/8dc8b63e1f5f8f98e2c590e549bbb4bfc1c319a2))


### Documentation

* add params class javadocs ([#43](https://github.com/anthropics/anthropic-sdk-java/issues/43)) ([6f0ce7b](https://github.com/anthropics/anthropic-sdk-java/commit/6f0ce7b62d8f8f985d06f52881ccaed66911adb1))
* add some missing javadocs ([#38](https://github.com/anthropics/anthropic-sdk-java/issues/38)) ([49a9056](https://github.com/anthropics/anthropic-sdk-java/commit/49a90567fc27cbadabf13cb0dc3a95125501d27a))
* publish dokka javadoc ([#53](https://github.com/anthropics/anthropic-sdk-java/issues/53)) ([8bd0316](https://github.com/anthropics/anthropic-sdk-java/commit/8bd03162f0e6800a0b8e03d854eaf69088b5948e))
* **readme:** fix misplaced period ([#45](https://github.com/anthropics/anthropic-sdk-java/issues/45)) ([bcdf8cd](https://github.com/anthropics/anthropic-sdk-java/commit/bcdf8cd51de09e2b5c54788bd22d54c88f532339))
* update some builder method javadocs ([#47](https://github.com/anthropics/anthropic-sdk-java/issues/47)) ([94a426b](https://github.com/anthropics/anthropic-sdk-java/commit/94a426ba16cf5fc852751c4fce67d4a8ef80267d))


### Styles

* **internal:** explicitly add some method return types ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **internal:** move headers and query params setters below others ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **internal:** simplify existing convenience setters on params ([2588011](https://github.com/anthropics/anthropic-sdk-java/commit/25880112453645c2bb9d7d333bede61835f22410))
* **internal:** sort fields ([#39](https://github.com/anthropics/anthropic-sdk-java/issues/39)) ([de172c3](https://github.com/anthropics/anthropic-sdk-java/commit/de172c38c727faeb76e602e970fb4f290b2cbd8f))


### Refactors

* **client:** switch query params objects to use `QueryParams` ([#31](https://github.com/anthropics/anthropic-sdk-java/issues/31)) ([29a101a](https://github.com/anthropics/anthropic-sdk-java/commit/29a101a34d1e2a33867fdc3f946dffb10c030aa4))
* **internal:** use constructor to deserialize json ([#32](https://github.com/anthropics/anthropic-sdk-java/issues/32)) ([6f08181](https://github.com/anthropics/anthropic-sdk-java/commit/6f0818132c13db29fb76800258820b8785607bc5))

## 0.1.0-alpha.6 (2024-12-28)

Full Changelog: [v0.1.0-alpha.5...v0.1.0-alpha.6](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.5...v0.1.0-alpha.6)

### Chores

* bump testing data uri ([#27](https://github.com/anthropics/anthropic-sdk-java/issues/27)) ([3261fbe](https://github.com/anthropics/anthropic-sdk-java/commit/3261fbe5818d21b3423873472243bccb899cb469))
* **docs:** add example project ([#25](https://github.com/anthropics/anthropic-sdk-java/issues/25)) ([9ba2956](https://github.com/anthropics/anthropic-sdk-java/commit/9ba2956a29bb23f00d2bb36fbf7563b552b56ede))
* **docs:** fix code block language ([#28](https://github.com/anthropics/anthropic-sdk-java/issues/28)) ([a686284](https://github.com/anthropics/anthropic-sdk-java/commit/a686284937af4e0c8f9b936899464c8e7c89f302))
* **docs:** update readme ([#24](https://github.com/anthropics/anthropic-sdk-java/issues/24)) ([d0891a2](https://github.com/anthropics/anthropic-sdk-java/commit/d0891a22de46658b1e82a3ebbe406f30ad69c387))
* format example ([729ca6a](https://github.com/anthropics/anthropic-sdk-java/commit/729ca6a49260477a2846d1d3d6b214499ef97e1d))
* update parameter examples in tests and docs ([#22](https://github.com/anthropics/anthropic-sdk-java/issues/22)) ([22fdc9c](https://github.com/anthropics/anthropic-sdk-java/commit/22fdc9c74f61fb6f634f2da28b0a6526e08652bd))


### Documentation

* add note about feedback ([79fc77b](https://github.com/anthropics/anthropic-sdk-java/commit/79fc77bb42a65585f8478e00736470f5008384fc))

## 0.1.0-alpha.5 (2024-12-17)

Full Changelog: [v0.1.0-alpha.4...v0.1.0-alpha.5](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.4...v0.1.0-alpha.5)

### Features

* **api:** general availability updates ([#21](https://github.com/anthropics/anthropic-sdk-java/issues/21)) ([a44228a](https://github.com/anthropics/anthropic-sdk-java/commit/a44228a42e6a591fe547cd1ea10eb8e2a98d9bf8))


### Chores

* **api:** update spec version ([#19](https://github.com/anthropics/anthropic-sdk-java/issues/19)) ([ecefc79](https://github.com/anthropics/anthropic-sdk-java/commit/ecefc796d89d2d1559d32729d801e46a8e4e271a))
* **internal:** remove unused and expand used wildcard imports ([#17](https://github.com/anthropics/anthropic-sdk-java/issues/17)) ([7a6d445](https://github.com/anthropics/anthropic-sdk-java/commit/7a6d445935d5f614b5dbb2755c0b339ad1879478))
* **internal:** remove unused and expand used wildcard imports ([#18](https://github.com/anthropics/anthropic-sdk-java/issues/18)) ([54bb13a](https://github.com/anthropics/anthropic-sdk-java/commit/54bb13af76d5628748be0d746c3dd43e3f9040f4))
* **internal:** remove unused imports ([#13](https://github.com/anthropics/anthropic-sdk-java/issues/13)) ([d7dcdbc](https://github.com/anthropics/anthropic-sdk-java/commit/d7dcdbc3b45e1942dc1cc9390bebd569321b788e))
* **internal:** update spec ([#20](https://github.com/anthropics/anthropic-sdk-java/issues/20)) ([bbe65de](https://github.com/anthropics/anthropic-sdk-java/commit/bbe65dece430c970d6e99ebf02b9dede955bfb0d))
* **test:** remove unused imports ([#15](https://github.com/anthropics/anthropic-sdk-java/issues/15)) ([9315104](https://github.com/anthropics/anthropic-sdk-java/commit/93151040179a609dfd362659e1d9c44a5d482339))
* **test:** use `JsonValue` instead of `JsonString` ([#16](https://github.com/anthropics/anthropic-sdk-java/issues/16)) ([13429e3](https://github.com/anthropics/anthropic-sdk-java/commit/13429e38d5a569e2f479283f24ebee08eecea88c))

## 0.1.0-alpha.4 (2024-12-11)

Full Changelog: [v0.1.0-alpha.3...v0.1.0-alpha.4](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.3...v0.1.0-alpha.4)

### Chores

* update example values in tests and docs ([#9](https://github.com/anthropics/anthropic-sdk-java/issues/9)) ([5f50cbb](https://github.com/anthropics/anthropic-sdk-java/commit/5f50cbb47bdec4c97f5839359735898a0b9d2857))


### Styles

* **internal:** make enum value definitions less verbose ([#11](https://github.com/anthropics/anthropic-sdk-java/issues/11)) ([cd0507b](https://github.com/anthropics/anthropic-sdk-java/commit/cd0507b1b6af02fb3c20ce9c4785f48a6de31af0))
* **internal:** move enum identity methods to bottom of class ([#12](https://github.com/anthropics/anthropic-sdk-java/issues/12)) ([804f3ec](https://github.com/anthropics/anthropic-sdk-java/commit/804f3ecac30aab1156d204df4d289a6553eb1a18))

## 0.1.0-alpha.3 (2024-12-10)

Full Changelog: [v0.1.0-alpha.2...v0.1.0-alpha.3](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.2...v0.1.0-alpha.3)

### Features

* docs: add example code ([#8](https://github.com/anthropics/anthropic-sdk-java/issues/8)) ([13e3a83](https://github.com/anthropics/anthropic-sdk-java/commit/13e3a83147fda14ff732481553d2e071487a453d))


### Documentation

* use latest sonnet in example snippets ([#6](https://github.com/anthropics/anthropic-sdk-java/issues/6)) ([a8f9175](https://github.com/anthropics/anthropic-sdk-java/commit/a8f91754a7ad26a8328a20dbbc4ee0051ae8aa06))

## 0.1.0-alpha.2 (2024-12-10)

Full Changelog: [v0.1.0-alpha.1...v0.1.0-alpha.2](https://github.com/anthropics/anthropic-sdk-java/compare/v0.1.0-alpha.1...v0.1.0-alpha.2)

### Chores

* **internal:** configure sonatype ([#4](https://github.com/anthropics/anthropic-sdk-java/issues/4)) ([d626be5](https://github.com/anthropics/anthropic-sdk-java/commit/d626be512503da86d9172cf1eb7ea952edeea120))


### Documentation

* add note about alpha to readme ([bda246c](https://github.com/anthropics/anthropic-sdk-java/commit/bda246c273b0c2308f15919f2ef45ee85e915a78))

## 0.1.0-alpha.1 (2024-12-09)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/anthropics/anthropic-sdk-java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### Features

* **java:** initial commit ([#2](https://github.com/anthropics/anthropic-sdk-java/issues/2)) ([213302e](https://github.com/anthropics/anthropic-sdk-java/commit/213302eb35e90468977cb397df6bfe2d0c37ece5))
