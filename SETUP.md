# 🛠️ Установка и настройка Frostpunk Mod

## Требования
- Java 21+ ([скачать](https://www.oracle.com/java/technologies/downloads/#java21))
- Git ([скачать](https://git-scm.com/download))
- IDE: IntelliJ IDEA (рекомендуется) или Eclipse

## Шаг 1: Клонируем репозиторий

```bash
git clone https://github.com/savelijkuhnikov-max/FrostpunkMod.git
cd FrostpunkMod
```

## Шаг 2: Настраиваем NeoForge dev environment

### Windows:
```bash
./gradlew genSourcesEclipse
```

### Linux/Mac:
```bash
./gradlew genSourcesEclipse
```

## Шаг 3: Импортируем в IDE

### IntelliJ IDEA:
1. Open `File` → `Open` → выбираем папку проекта
2. Нажимаем на `build.gradle` → `Open as Project`
3. Дождаться индексации (может быть долго)
4. В IntelliJ откроется автоматическая конфигурация

### Eclipse:
1. `File` → `Import` → `Gradle` → `Existing Gradle Project`
2. Выбираем папку проекта
3. `Finish`

## Шаг 4: Генерируем ресурсы и запускаем

```bash
./gradlew build
```

Это займет 5-15 минут в первый раз.

## Шаг 5: Запуск dev сервера в IDE

### IntelliJ IDEA:
1. Справа → `Gradle` → `FrostpunkMod` → `Tasks` → `fg_runs`
2. Двойной клик на `runClient` или `runServer`
3. Запустится Minecraft с модом

### Eclipse:
Аналогично, но через Gradle Tasks

## 🎮 Запуск игры

После первого `./gradlew build`:
- Minecraft откроется с модом автоматически
- Создай новый мир в cold/snowy биоме
- Начинай выживать! ❄️

## 📝 Компиляция для релиза

```bash
./gradlew build
```

Jar файл появится в: `build/libs/FrostpunkMod-1.0.0.jar`

## 🐛 Troubleshooting

### Ошибка: "Java 21 not found"
```bash
# Установи Java 21 и укажи путь:
export JAVA_HOME=/path/to/java21  # Linux/Mac
set JAVA_HOME=C:\\path\\to\\java21  # Windows
```

### Ошибка: "Gradle download failed"
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

### IDE не видит классы
```bash
./gradlew cleanEclipse genSourcesEclipse
# Или для IntelliJ - просто переопрыть проект
```

## 🚀 Готово!

Теперь ты можешь:
- ✏️ Редактировать код
- 🔨 Добавлять новые блоки и предметы
- 🧪 Тестировать в game client
- 📦 Собирать готовый мод

Приступай к разработке! 🔥