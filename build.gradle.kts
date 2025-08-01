import earth.terrarium.cloche.api.metadata.ModMetadata

plugins {
    id("earth.terrarium.cloche") version "0.11.20"
}

repositories {
    cloche.librariesMinecraft()

    mavenCentral()

    cloche {
        main()

        mavenFabric()
        mavenNeoforged()
        mavenNeoforgedMeta()
    }
}


dependencies {
    compileOnly("org.jetbrains:annotations:26.0.0")
}

cloche {
    minecraftVersion = properties["minecraftVersion"] as String

    mappings {
        official()
        parchment("2024.11.17")
    }

    metadata {
        modId = "randomized_gyr"
        name = "Randomized Gyr"
        description = "Blep"
        author("OracleHisty")
        license = "lgpl3"
        issues = "https://github.com/OracleHisty/Gyr-Randomized-Equipment/issues"
        sources = "https://github.com/OracleHisty/Gyr-Randomized-Equipment"
    }

    common {
        dependencies {
        }
    }

    neoforge {
        data {

        }

        loaderVersion = properties["neoforgeVersion"] as String

        metadata {
            modLoader = "javafml"
            loaderVersion("1")

            dependency {
                modId = "neoforge"
                required = true
                version("20")
            }
            dependency {
                modId = "minecraft"
                required = true
                version("1.20.6")
            }
        }

        dependencies {
        }

        runs {
            server()
            client()
            data()
        }
    }

    fabric {
        data {

        }

        metadata {
            entrypoint("main", "net.oraclehisty.gyr_randomized.FabricGyrRandomized")
            dependency {
                modId = "fabric"
                version("*")
            }
            dependency {
                modId = "fabric"
                modId = ">=1.20.6"
            }
        }

        loaderVersion = properties["fabricLoaderVersion"] as String

        dependencies {
            fabricApi(properties["fabricApiVersion"] as String)

            dependencies {
            }
        }

        runs {
            server()
            client()
            data()
        }
    }
}