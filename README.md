# Selection Save Plugin
Муллер Даниил, M33021

# Функции
Плагин позволяет по сочетанию клавиш (```Ctrl + Alt + X```) сохранять выделенный в редакторе кода текст в отдельный файл в папке ```selections```. В случае существования файла выделенный текст дописывается в конец файла. По умолчанию сохраняемому файлу присваивается имя в формате ```selection_date_time```, где ```date_time``` - текущие дата и время.

# Enhancements
В настоящей версии реализован только ```DefaultSelectionSaver``` - класс-реализация ```SelectionSaver``` (интерфейс, отвечающий зв сохранение выделенного текста), которая сохраняет файлы в ```user.dir/collections///. Можно реализовать класс, в котором можно указать папку для сохранения.

# Разработка
Плагин можно, используя сборку Gradle, который автоматически создает необходимые файлы, в том числе - ```plugin.xml```, содержащий информацию о плагине, extension points и связанных actions.
Есть возможность запустить еще один instance Intellij IDEA для тестирования работы плагина.
С помощью Marketplace можно опубликовать плагин в Marketplace для дальнейшего подключения из него.
