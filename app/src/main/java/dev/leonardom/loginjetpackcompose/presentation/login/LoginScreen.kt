package dev.leonardom.loginjetpackcompose.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import dev.leonardom.loginjetpackcompose.R
import dev.leonardom.loginjetpackcompose.presentation.components.RoundedButton
import dev.leonardom.loginjetpackcompose.presentation.components.TransparentTextField
import dev.leonardom.loginjetpackcompose.ui.theme.Poppins
import dev.leonardom.loginjetpackcompose.ui.theme.Shapes
import kotlin.math.round

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    val emailValue = rememberSaveable { mutableStateOf("") }
    val passwordValue = rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painterResource(id = R.drawable.vector_3),
            contentScale = ContentScale.FillWidth, contentDescription = null,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .zIndex(1f)
                .fillMaxWidth(),

            )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            contentAlignment = Alignment.TopCenter

        ) {

            ConstraintLayout {

                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        bottomEndPercent = 6,
                        bottomStartPercent = 6
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            fontSize = 35.sp,
                            text = "¡HOLA!",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier= Modifier.offset(0.dp, (-155).dp),
                            color = Color(0xFF14466D),
                            letterSpacing = 4.sp,
                        )
                        Text(
                            fontSize = 17.sp,
                            text = "¡Te estábamos esperando!\n Ingresa tu cuenta IDEC.",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.offset(0.dp, (-140).dp),
                            color = Color(0xFF14466D),
                            letterSpacing = 2.5.sp,

                            )




                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            TransparentTextField(
                                textFieldValue = emailValue,
                                textLabel = "Email",

                                keyboardType = KeyboardType.Email,
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                ),
                                imeAction = ImeAction.Next,
                                modifier = Modifier
                                    .offset(0.dp, (-110).dp)
                                    .width(291.dp)
                                    .height(57.dp),
                                shape = RoundedCornerShape(
                                    bottomEndPercent = 6,
                                    bottomStartPercent = 6
                                ),
                                color= Color(0x2815476E),
                            )

                            TransparentTextField(
                                modifier = Modifier
                                    .offset(0.dp, (-100).dp)
                                    .width(291.dp)
                                    .height(57.dp),
                                shape = RoundedCornerShape(
                                    bottomEndPercent = 4,
                                    bottomStartPercent = 4
                                ),
                                textFieldValue = passwordValue,
                                textLabel = "Contraseña",
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()

                                        //TODO("LOGIN")
                                    }
                                ),
                                imeAction = ImeAction.Done,
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            passwordVisibility = !passwordVisibility
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (passwordVisibility) {
                                                Icons.Default.Visibility
                                            } else {
                                                Icons.Default.VisibilityOff
                                            },
                                            contentDescription = "Toggle Password Icon"
                                        )
                                    }
                                },
                                visualTransformation = if (passwordVisibility) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                },
                                color = Color(0x2815476E),

                            )



                        }



                    }

                }


            }

            ConstraintLayout() {

                Box(
                    modifier = Modifier.fillMaxHeight(),
                    /*contentAlignment = Alignment.BottomCenter,*/


                    )

                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        bottomEndPercent = 8,
                        bottomStartPercent = 8
                    )
                )

                {

                    Image(
                        painter = painterResource(id = R.drawable.login_noback),
                        contentDescription = "Login Image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset((0).dp, (40).dp)
                            .padding(bottom = 100.dp)
                            .size(250.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(60.dp)
                    )

                    {
                        RoundedButton(
                            text = "Ingresar",
                            displayProgressBar = false,
                            color= Color(0xFF15476E ),
                            onClick = {
                                // TODO("LOGIN")
                            },
                            modifier = Modifier
                                .offset((0).dp, (-0).dp)
                                .size(150.dp, 50.dp)


                        )

                        Row {
                            Box {

                                ClickableText(
                                    text = buildAnnotatedString {

                                        withStyle(
                                            style = SpanStyle(
                                                fontFamily = Poppins,
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 19.sp,
                                                letterSpacing = 3.sp,
                                                color = Color(0xFF14466D)
                                            )
                                        ) {
                                            append("REGISTRARSE")
                                        }
                                    },
                                    modifier = Modifier.offset(0.dp, (220).dp),

                                )
                                {
                                    // TODO("NAVIGATE TO REGISTER SCREEN")
                                }
                            }
                        }
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset((0).dp, (160).dp),
                            text = "¿ Haz olvidado tu contraseña?",
                            style = TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Medium, fontSize = 12.sp),
                            textAlign = TextAlign.Center,
                            color = Color(0xFF14466D)

                            )
                    }
                }

            }
        }
    }

}






















