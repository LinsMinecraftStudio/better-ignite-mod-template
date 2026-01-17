plugins {
  id("mod.base-conventions")
  id("io.github.gliczdev.access-widen") version "1.0.0"
}

dependencies {
  paperweight.paperDevBundle(libs.versions.paper)

  compileOnly(libs.ignite)
  compileOnly(libs.mixin)
  compileOnly(libs.mixinExtras)

  annotationProcessor(libs.mixinExtras)
  
  paperweight.paperDevBundle(libs.versions.paper)

  accessWiden("io.papermc.paper:paper-server:userdev-${libs.versions.paper.get()}")
}

accessWideners {
  files.from("./src/main/resources/example_mod.accesswidener")
}

tasks.build {
  dependsOn(tasks.applyAccessWideners)
}