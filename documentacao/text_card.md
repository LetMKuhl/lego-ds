# Card Text

### Implementando
Veja abaixo alguns exemplos de como implementar o componente. Você pode conferir mais detalhes e 
possibilidades através das tabelas de propriedades e eventos no fim da página:

#### Primary

```xml
<com.lehlagoo.legods.view.CardView
        android:id="@+id/card_1"
        app:number_comments="@string/default_comments_1"
        app:number_likes="@string/default_likes_1"
        app:text_card="@string/default_text_card_1" />
```

### Propriedades

| Nome          | Descrição                                              | Tipo      | Obrigatório |
|---------------|--------------------------------------------------------|-----------|-------------|
|number_comments| Define a quantidade de comentarios que o card irá ter  |   String  |     Sim     |
|number_likes   | Define a quantidade de likes que o card irá ter        |   String  |     Sim     |
|text_card      | Define o texto que irá ser inserido no card            |   String  |     Sim     |
