package pl.ukaszapps.curricullumvitae.view.composables

import androidx.compose.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.res.stringResource
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.part_contact_data.view.*
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.domain.model.ContactInfo
import pl.ukaszapps.curricullumvitae.view.model.Error

import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value
import pl.ukaszapps.curricullumvitae.view.showUrl

@Model
class SocialButtonModel(var urlState: ResultState<String>)

@Composable
fun SocialButton(name: String, model: SocialButtonModel, action: (String) -> Unit) {
    with(model) {
        when (val state = urlState) {
            is Value -> Button(text = name, onClick = { action(state.value) })
            else -> CircularProgressIndicator()
        }
    }
}

@Composable
fun ContactData(
    lifecycleOwner: LifecycleOwner,
    infoLiveData: LiveData<ResultState<ContactInfo>>
) {
    val infoLiveState = +state<ResultState<ContactInfo>>{
        Loading<ContactInfo>()
    }

    infoLiveData.observe(owner = lifecycleOwner) { resultState ->
        infoLiveState.value = resultState
    }

    ContactDataContentState(infoLiveState.value)
}

@Composable
fun ContactDataContentState(contactInfoState: ResultState<ContactInfo>) {
    Card {
        when (val ci = contactInfoState) {
            is Loading -> CircularProgressIndicator()
            is Error -> Center {
                Text(
                    text = ci.errorMessage,
                    style = (+themeTextStyle { subtitle2 }).copy(color = +themeColor { error })

                )
            }
            is Value -> ContactDataInfoView(ci.value)
        }
    }
}
@Composable
fun ContactDataInfoView(value: ContactInfo) {
    val context = +ambient(ContextAmbient)
    Column {
        Text(text = value.address)
        Row(mainAxisSize = LayoutSize.Expand,
            mainAxisAlignment = MainAxisAlignment.SpaceEvenly) {
            Button(text = +stringResource(R.string.label_github),
                onClick = {
                    context.showUrl(value.github)
                })
            Button(text = +stringResource(R.string.label_bitbucket),
                onClick = {
                    context.showUrl(value.bitbucket)
                })
            Button(text = +stringResource(R.string.label_linkedin),
                onClick = {
                    context.showUrl(value.linkedin)
                })
        }
    }
}
