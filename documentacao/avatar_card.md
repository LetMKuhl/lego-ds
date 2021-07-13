# Avatar Card

### Implementando
Veja abaixo alguns exemplos de como implementar o componente. Você pode conferir mais detalhes e 
possibilidades através das tabelas de propriedades e eventos no fim da página:

#### Primary

```xml
    <com.lehlagoo.legods.view.ImageAvatarCardView
        android:id="@+id/avatar_card"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:backgroundTint="@color/color_white"
        app:avatar_username="@string/default_username"
        app:avatar_username_job="@string/default_job"
        app:follow_button="@string/follow_button"
        />
```

```kotlin

//Função responsavel pela implementação
private fun refreshState() {

        isEnabled = buttonState.isEnabled
        isClickable = buttonState.isEnabled

        refreshDrawableState()

        avatarBinding.followButton.run {
            isEnabled = true
            isClickable = true
        }

        when (buttonState) {
            ChangeCardState.Follow ->
                avatarBinding.followButton.text = followButton
            ChangeCardState.Unfollow ->
                avatarBinding.followButton.text = unfollowButton
        }

        avatarBinding.avatarUsername.run {
            isEnabled = buttonState.isEnabled
        }

        when (usernameState) {
            ChangeCardState.User ->
                avatarBinding.avatarUsername.text = avatarUsername
        }

        avatarBinding.avatarUsernameJob.run {
            isEnabled = buttonState.isEnabled
        }

        when (jobState) {
            ChangeCardState.Job ->
                avatarBinding.avatarUsernameJob.text = avatarUsernameJob
        }
    }
```

### Propriedades

| Nome              | Descrição                                          | Tipo      | Obrigatório |
|-------------------|----------------------------------------------------|-----------|-------------|
|avatar_username    | Define o username no card                          |   String  |     Sim     |
|avatar_username_job| Define o cargo de trabalho que o user tem no card  |   String  |     Sim     |
|follow_button      | Define a escrita no botão lateral do card          |   String  |     sim     |
|backgroundTint     | Define a cor do card inteiro                       |   String  |     Não     |