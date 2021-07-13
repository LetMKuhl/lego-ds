# Typography

### Implementando
Veja abaixo alguns exemplos de como implementar o componente. Você pode conferir mais detalhes e 
possibilidades através das tabelas de propriedades e eventos no fim da página:

#### Primary

```xml
<TextView
        android:id="@+id/text_example_card"
        style="@style/TextAppearance.Heading4"/>
```

##### Modelos
```xml
<resources>

    <style name="TextAppearance.Heading1"/>

    <style name="TextAppearance.Heading2"/>

    <style name="TextAppearance.Heading3"/>
       
    <style name="TextAppearance.Heading4"/>
        
    <style name="TextAppearance.Heading5"/>
       
    <style name="TextAppearance.Subtitle1"/>
     
    <style name="TextAppearance.Subtitle2"/>
        
    <style name="TextAppearance.Subtitle3"/>
        
    <style name="TextAppearance.Subtitle4"/>
 
    <style name="TextAppearance.Paragraph"/>
   
</resources>
```

### Propriedades

| Nome    | Descrição                                                    | Tipo      | Obrigatório |
|---------|--------------------------------------------------------------|-----------|-------------|
| style   | Define o estilo da fonte                                    |   String  |    Sim      |