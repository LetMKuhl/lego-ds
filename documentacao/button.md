# Button

### Implementando
Veja abaixo alguns exemplos de como implementar o componente. Você pode conferir mais detalhes e 
possibilidades através das tabelas de propriedades e eventos no fim da página:

#### Primary

```xml
<com.lehlagoo.legods.view.ProgressPrimaryButton
        android:id="@+id/button_primary"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:title_primary_button="@string/primary_button"
        app:title_primary_disabled_button="@string/disabled_button"/>
```

```kotlin
        binding.buttonPrimary.setOnClickListener {
            binding.buttonPrimary.setDisabled()
            val intent = Intent(this, ImageAvatarCardActivity::class.java)

            lifecycleScope.launch {
                delay(2_000)
                binding.buttonPrimary.setNormal()
            }
        }
```

#### Secondary

```xml
<com.lehlagoo.legods.view.ProgressSecondaryButton
        android:id="@+id/button_secondary"
        android:contentDescription="@string/secondary_button"
        app:title_secondary_button="@string/secondary_button"
        app:title_secondary_disabled_button="@string/disabled_button" />
```

```kotlin
binding.buttonSecondary.setOnClickListener {
            binding.buttonSecondary.setDisabled()
            val intent = Intent(this, CardViewActivity::class.java)

            lifecycleScope.launch {
                delay(2_000)
                binding.buttonSecondary.setNormal()
            }
        }
```

### Propriedades

| Nome    | Descrição                                                    | Tipo      | Obrigatório |
|---------|--------------------------------------------------------------|-----------|-------------|
| text    | Define o texto a ser exibido no botão                        |   String  |    Sim      |
| icon    | Define o ícone a ser mostrado do lado direito do botão.      |   String  |    Sim      |