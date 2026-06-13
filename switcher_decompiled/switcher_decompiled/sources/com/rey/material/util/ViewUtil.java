package com.rey.material.util;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.rey.material.R;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtil {
    public static final long FRAME_DURATION = 16;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT < 17) {
            do {
                atomicInteger = sNextGeneratedId;
                i = atomicInteger.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!atomicInteger.compareAndSet(i, i2));
            return i;
        }
        return View.generateViewId();
    }

    public static boolean hasState(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void applyStyle(View view, int i) {
        applyStyle(view, (AttributeSet) null, 0, i);
    }

    public static void applyStyle(View view, AttributeSet attributeSet, int i, int i2) {
        int i3;
        boolean z;
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.View, i, i2);
        int i4 = 0;
        int dimensionPixelSize = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int paddingStart = Integer.MIN_VALUE;
        boolean z5 = false;
        int paddingLeft = -1;
        int paddingEnd = Integer.MIN_VALUE;
        int paddingTop = -1;
        int paddingRight = -1;
        int paddingBottom = -1;
        for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i4 < indexCount; indexCount = i3) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            if (index == R.styleable.View_android_background) {
                setBackground(view, typedArrayObtainStyledAttributes.getDrawable(index));
            } else if (index == R.styleable.View_android_backgroundTint) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view.setBackgroundTintList(typedArrayObtainStyledAttributes.getColorStateList(index));
                }
            } else {
                if (index == R.styleable.View_android_backgroundTintMode) {
                    i3 = indexCount;
                    if (Build.VERSION.SDK_INT >= 21) {
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 3);
                        if (i5 != 3) {
                            if (i5 != 5) {
                                if (i5 == 9) {
                                    view.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
                                } else {
                                    switch (i5) {
                                        case 14:
                                            view.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                                            break;
                                        case 15:
                                            view.setBackgroundTintMode(PorterDuff.Mode.SCREEN);
                                            break;
                                        case 16:
                                            view.setBackgroundTintMode(PorterDuff.Mode.ADD);
                                            break;
                                    }
                                }
                            } else {
                                view.setBackgroundTintMode(PorterDuff.Mode.SRC_IN);
                            }
                        } else {
                            view.setBackgroundTintMode(PorterDuff.Mode.SRC_OVER);
                        }
                    }
                } else {
                    i3 = indexCount;
                    if (index == R.styleable.View_android_elevation) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            view.setElevation(typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, 0));
                        }
                    } else {
                        if (index == R.styleable.View_android_padding) {
                            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, -1);
                            z2 = true;
                        } else {
                            if (index == R.styleable.View_android_paddingLeft) {
                                paddingLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, -1);
                                z2 = true;
                            } else if (index == R.styleable.View_android_paddingTop) {
                                paddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, -1);
                            } else if (index == R.styleable.View_android_paddingRight) {
                                paddingRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, -1);
                            } else if (index == R.styleable.View_android_paddingBottom) {
                                paddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, -1);
                            } else if (index == R.styleable.View_android_paddingStart) {
                                if (Build.VERSION.SDK_INT >= 17) {
                                    paddingStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MIN_VALUE);
                                    z3 = paddingStart != Integer.MIN_VALUE;
                                }
                            } else if (index == R.styleable.View_android_paddingEnd) {
                                if (Build.VERSION.SDK_INT >= 17) {
                                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MIN_VALUE);
                                    z5 = dimensionPixelSize2 != Integer.MIN_VALUE;
                                    paddingEnd = dimensionPixelSize2;
                                }
                            } else if (index == R.styleable.View_android_fadeScrollbars) {
                                view.setScrollbarFadingEnabled(typedArrayObtainStyledAttributes.getBoolean(index, true));
                            } else if (index == R.styleable.View_android_fadingEdgeLength) {
                                view.setFadingEdgeLength(typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, 0));
                            } else if (index == R.styleable.View_android_minHeight) {
                                view.setMinimumHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                            } else if (index == R.styleable.View_android_minWidth) {
                                view.setMinimumWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                            } else if (index == R.styleable.View_android_requiresFadingEdge) {
                                view.setVerticalFadingEdgeEnabled(typedArrayObtainStyledAttributes.getBoolean(index, true));
                            } else if (index == R.styleable.View_android_scrollbarDefaultDelayBeforeFade) {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    view.setScrollBarDefaultDelayBeforeFade(typedArrayObtainStyledAttributes.getInteger(index, 0));
                                }
                            } else if (index == R.styleable.View_android_scrollbarFadeDuration) {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    view.setScrollBarFadeDuration(typedArrayObtainStyledAttributes.getInteger(index, 0));
                                }
                            } else if (index == R.styleable.View_android_scrollbarSize) {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    view.setScrollBarSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                                }
                            } else if (index == R.styleable.View_android_scrollbarStyle) {
                                int integer = typedArrayObtainStyledAttributes.getInteger(index, 0);
                                if (integer == 0) {
                                    view.setScrollBarStyle(0);
                                } else if (integer == 16777216) {
                                    view.setScrollBarStyle(16777216);
                                } else if (integer == 33554432) {
                                    view.setScrollBarStyle(33554432);
                                } else if (integer == 50331648) {
                                    view.setScrollBarStyle(50331648);
                                }
                            } else if (index == R.styleable.View_android_soundEffectsEnabled) {
                                view.setSoundEffectsEnabled(typedArrayObtainStyledAttributes.getBoolean(index, true));
                            } else if (index == R.styleable.View_android_textAlignment) {
                                if (Build.VERSION.SDK_INT >= 17) {
                                    switch (typedArrayObtainStyledAttributes.getInteger(index, 0)) {
                                        case 0:
                                            view.setTextAlignment(0);
                                            continue;
                                        case 1:
                                            view.setTextAlignment(1);
                                            break;
                                        case 2:
                                            view.setTextAlignment(2);
                                            break;
                                        case 3:
                                            view.setTextAlignment(3);
                                            break;
                                        case 4:
                                            view.setTextAlignment(4);
                                            break;
                                        case 5:
                                            view.setTextAlignment(5);
                                            break;
                                        case 6:
                                            view.setTextAlignment(6);
                                            break;
                                    }
                                }
                            } else if (index == R.styleable.View_android_textDirection) {
                                if (Build.VERSION.SDK_INT >= 17) {
                                    int integer2 = typedArrayObtainStyledAttributes.getInteger(index, 0);
                                    if (integer2 != 0) {
                                        if (integer2 == 1) {
                                            view.setTextDirection(1);
                                        } else if (integer2 == 2) {
                                            view.setTextDirection(2);
                                        } else if (integer2 == 3) {
                                            view.setTextDirection(3);
                                        } else if (integer2 == 4) {
                                            view.setTextDirection(4);
                                        } else if (integer2 == 5) {
                                            view.setTextDirection(5);
                                        }
                                        z = false;
                                    } else {
                                        z = false;
                                        view.setTextDirection(0);
                                    }
                                }
                            } else {
                                z = false;
                                if (index == R.styleable.View_android_visibility) {
                                    int integer3 = typedArrayObtainStyledAttributes.getInteger(index, 0);
                                    if (integer3 == 0) {
                                        view.setVisibility(0);
                                    } else if (integer3 == 1) {
                                        view.setVisibility(4);
                                    } else if (integer3 == 2) {
                                        view.setVisibility(8);
                                    }
                                } else if (index == R.styleable.View_android_layoutDirection) {
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        int integer4 = typedArrayObtainStyledAttributes.getInteger(index, 0);
                                        if (integer4 == 0) {
                                            view.setLayoutDirection(0);
                                        } else if (integer4 == 1) {
                                            view.setLayoutDirection(1);
                                        } else if (integer4 == 2) {
                                            view.setLayoutDirection(2);
                                        } else if (integer4 == 3) {
                                            view.setLayoutDirection(3);
                                        }
                                    }
                                } else if (index == R.styleable.View_android_src && (view instanceof ImageView)) {
                                    ((ImageView) view).setImageResource(typedArrayObtainStyledAttributes.getResourceId(index, 0));
                                }
                            }
                            i4++;
                        }
                        z4 = true;
                        i4++;
                    }
                }
                i4++;
            }
            i3 = indexCount;
            i4++;
        }
        if (dimensionPixelSize >= 0) {
            view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        } else if (Build.VERSION.SDK_INT < 17) {
            if (!z3) {
                paddingStart = paddingLeft;
            }
            if (!z5) {
                paddingEnd = paddingRight;
            }
            if (paddingStart < 0) {
                paddingStart = view.getPaddingLeft();
            }
            if (paddingTop < 0) {
                paddingTop = view.getPaddingTop();
            }
            int i6 = paddingTop;
            if (paddingEnd < 0) {
                paddingEnd = view.getPaddingRight();
            }
            int i7 = paddingEnd;
            if (paddingBottom < 0) {
                paddingBottom = view.getPaddingBottom();
            }
            view.setPadding(paddingStart, i6, i7, paddingBottom);
        } else {
            if (z2 || z4) {
                if (!z2) {
                    paddingLeft = view.getPaddingLeft();
                }
                int i8 = paddingLeft;
                int paddingTop2 = paddingTop >= 0 ? paddingTop : view.getPaddingTop();
                if (!z4) {
                    paddingRight = view.getPaddingRight();
                }
                view.setPadding(i8, paddingTop2, paddingRight, paddingBottom >= 0 ? paddingBottom : view.getPaddingBottom());
            }
            if (z3 || z5) {
                if (!z3) {
                    paddingStart = view.getPaddingStart();
                }
                if (paddingTop < 0) {
                    paddingTop = view.getPaddingTop();
                }
                int i9 = paddingTop;
                if (!z5) {
                    paddingEnd = view.getPaddingEnd();
                }
                int i10 = paddingEnd;
                if (paddingBottom < 0) {
                    paddingBottom = view.getPaddingBottom();
                }
                view.setPaddingRelative(paddingStart, i9, i10, paddingBottom);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        if (view instanceof TextView) {
            applyStyle((TextView) view, attributeSet, i, i2);
        }
    }

    public static void applyFont(TextView textView, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.tv_fontFamily}, i, i2);
        String string = typedArrayObtainStyledAttributes.getString(0);
        if (string != null) {
            textView.setTypeface(TypefaceUtil.load(textView.getContext(), string, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void applyTextAppearance(TextView textView, int i) {
        float f;
        float f2;
        int i2;
        String string;
        int i3;
        Typeface typefaceLoad;
        if (i == 0) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(i, R.styleable.TextAppearance);
        int i4 = -1;
        float f3 = 0.0f;
        int i5 = 0;
        if (typedArrayObtainStyledAttributes != null) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int i6 = -1;
            i3 = -1;
            f = 0.0f;
            f2 = 0.0f;
            float f4 = 0.0f;
            int i7 = 0;
            int i8 = 0;
            string = null;
            while (i7 < indexCount) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.TextAppearance_android_textColorHighlight) {
                    textView.setHighlightColor(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.TextAppearance_android_textColor) {
                    textView.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
                } else if (index == R.styleable.TextAppearance_android_textColorHint) {
                    textView.setHintTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
                } else if (index == R.styleable.TextAppearance_android_textColorLink) {
                    textView.setLinkTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
                } else if (index == R.styleable.TextAppearance_android_textSize) {
                    textView.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.TextAppearance_android_typeface) {
                    i3 = typedArrayObtainStyledAttributes.getInt(index, i4);
                } else if (index == R.styleable.TextAppearance_android_fontFamily) {
                    string = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.TextAppearance_tv_fontFamily) {
                    string = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.TextAppearance_android_textStyle) {
                    i6 = typedArrayObtainStyledAttributes.getInt(index, i4);
                } else if (index == R.styleable.TextAppearance_android_textAllCaps) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(index, false));
                    }
                } else if (index == R.styleable.TextAppearance_android_shadowColor) {
                    i8 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.TextAppearance_android_shadowDx) {
                    f = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.TextAppearance_android_shadowDy) {
                    f2 = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.TextAppearance_android_shadowRadius) {
                    f4 = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.TextAppearance_android_elegantTextHeight) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView.setElegantTextHeight(typedArrayObtainStyledAttributes.getBoolean(index, false));
                    }
                } else if (index == R.styleable.TextAppearance_android_letterSpacing) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView.setLetterSpacing(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == R.styleable.TextAppearance_android_fontFeatureSettings && Build.VERSION.SDK_INT >= 21) {
                    textView.setFontFeatureSettings(typedArrayObtainStyledAttributes.getString(index));
                }
                i7++;
                i4 = -1;
            }
            typedArrayObtainStyledAttributes.recycle();
            i2 = i6;
            i5 = i8;
            f3 = f4;
        } else {
            f = 0.0f;
            f2 = 0.0f;
            i2 = -1;
            string = null;
            i3 = -1;
        }
        if (i5 != 0) {
            textView.setShadowLayer(f3, f, f2, i5);
        }
        if (string != null) {
            typefaceLoad = TypefaceUtil.load(textView.getContext(), string, i2);
            if (typefaceLoad != null) {
                textView.setTypeface(typefaceLoad);
            }
        } else {
            typefaceLoad = null;
        }
        if (typefaceLoad != null) {
            if (i3 == 1) {
                typefaceLoad = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                typefaceLoad = Typeface.SERIF;
            } else if (i3 == 3) {
                typefaceLoad = Typeface.MONOSPACE;
            }
            textView.setTypeface(typefaceLoad, i2);
        }
    }

    private static void applyStyle(TextView textView, AttributeSet attributeSet, int i, int i2) {
        int i3;
        float f;
        float f2;
        float f3;
        int i4;
        int i5;
        String string;
        Typeface typeface;
        int i6;
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, R.styleable.TextViewAppearance, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TextViewAppearance_android_textAppearance, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = resourceId != 0 ? textView.getContext().obtainStyledAttributes(resourceId, R.styleable.TextAppearance) : null;
        int i7 = 14;
        if (typedArrayObtainStyledAttributes2 != null) {
            int indexCount = typedArrayObtainStyledAttributes2.getIndexCount();
            int i8 = 0;
            i3 = 0;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            i4 = -1;
            i5 = -1;
            string = null;
            while (i8 < indexCount) {
                int index = typedArrayObtainStyledAttributes2.getIndex(i8);
                if (index == R.styleable.TextAppearance_android_textColorHighlight) {
                    textView.setHighlightColor(typedArrayObtainStyledAttributes2.getColor(index, 0));
                } else if (index == R.styleable.TextAppearance_android_textColor) {
                    textView.setTextColor(typedArrayObtainStyledAttributes2.getColorStateList(index));
                } else if (index == R.styleable.TextAppearance_android_textColorHint) {
                    textView.setHintTextColor(typedArrayObtainStyledAttributes2.getColorStateList(index));
                } else if (index == R.styleable.TextAppearance_android_textColorLink) {
                    textView.setLinkTextColor(typedArrayObtainStyledAttributes2.getColorStateList(index));
                } else if (index == R.styleable.TextAppearance_android_textSize) {
                    textView.setTextSize(0, typedArrayObtainStyledAttributes2.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.TextAppearance_android_typeface) {
                    i4 = typedArrayObtainStyledAttributes2.getInt(index, -1);
                } else if (index == R.styleable.TextAppearance_android_fontFamily) {
                    string = typedArrayObtainStyledAttributes2.getString(index);
                } else if (index == R.styleable.TextAppearance_tv_fontFamily) {
                    string = typedArrayObtainStyledAttributes2.getString(index);
                } else if (index == R.styleable.TextAppearance_android_textStyle) {
                    i5 = typedArrayObtainStyledAttributes2.getInt(index, -1);
                } else if (index == R.styleable.TextAppearance_android_textAllCaps) {
                    if (Build.VERSION.SDK_INT >= i7) {
                        textView.setAllCaps(typedArrayObtainStyledAttributes2.getBoolean(index, false));
                    }
                } else if (index == R.styleable.TextAppearance_android_shadowColor) {
                    i3 = typedArrayObtainStyledAttributes2.getInt(index, 0);
                } else if (index == R.styleable.TextAppearance_android_shadowDx) {
                    f = typedArrayObtainStyledAttributes2.getFloat(index, 0.0f);
                } else if (index == R.styleable.TextAppearance_android_shadowDy) {
                    f2 = typedArrayObtainStyledAttributes2.getFloat(index, 0.0f);
                } else if (index == R.styleable.TextAppearance_android_shadowRadius) {
                    f3 = typedArrayObtainStyledAttributes2.getFloat(index, 0.0f);
                } else if (index == R.styleable.TextAppearance_android_elegantTextHeight) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView.setElegantTextHeight(typedArrayObtainStyledAttributes2.getBoolean(index, false));
                    }
                } else if (index == R.styleable.TextAppearance_android_letterSpacing) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView.setLetterSpacing(typedArrayObtainStyledAttributes2.getFloat(index, 0.0f));
                    }
                } else if (index == R.styleable.TextAppearance_android_fontFeatureSettings && Build.VERSION.SDK_INT >= 21) {
                    textView.setFontFeatureSettings(typedArrayObtainStyledAttributes2.getString(index));
                }
                i8++;
                i7 = 14;
            }
            typedArrayObtainStyledAttributes2.recycle();
        } else {
            i3 = 0;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            i4 = -1;
            i5 = -1;
            string = null;
        }
        TypedArray typedArrayObtainStyledAttributes3 = textView.getContext().obtainStyledAttributes(attributeSet, R.styleable.TextView, i, i2);
        int i9 = 0;
        boolean z = false;
        float f4 = f3;
        String str = string;
        int i10 = i4;
        int i11 = i5;
        Drawable drawable = null;
        Drawable drawable2 = null;
        Drawable drawable3 = null;
        Drawable drawable4 = null;
        Drawable drawable5 = null;
        Drawable drawable6 = null;
        boolean z2 = false;
        for (int indexCount2 = typedArrayObtainStyledAttributes3.getIndexCount(); i9 < indexCount2; indexCount2 = i6) {
            int index2 = typedArrayObtainStyledAttributes3.getIndex(i9);
            if (index2 == R.styleable.TextView_android_drawableLeft) {
                drawable2 = typedArrayObtainStyledAttributes3.getDrawable(index2);
            } else if (index2 == R.styleable.TextView_android_drawableTop) {
                drawable3 = typedArrayObtainStyledAttributes3.getDrawable(index2);
            } else if (index2 == R.styleable.TextView_android_drawableRight) {
                drawable5 = typedArrayObtainStyledAttributes3.getDrawable(index2);
            } else if (index2 == R.styleable.TextView_android_drawableBottom) {
                drawable6 = typedArrayObtainStyledAttributes3.getDrawable(index2);
            } else {
                if (index2 == R.styleable.TextView_android_drawableStart) {
                    drawable = typedArrayObtainStyledAttributes3.getDrawable(index2);
                } else if (index2 == R.styleable.TextView_android_drawableEnd) {
                    drawable4 = typedArrayObtainStyledAttributes3.getDrawable(index2);
                } else {
                    if (index2 == R.styleable.TextView_android_drawablePadding) {
                        textView.setCompoundDrawablePadding(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, 0));
                    } else if (index2 == R.styleable.TextView_android_maxLines) {
                        textView.setMaxLines(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                    } else {
                        i6 = indexCount2;
                        if (index2 == R.styleable.TextView_android_maxHeight) {
                            textView.setMaxHeight(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_lines) {
                            textView.setLines(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_height) {
                            textView.setHeight(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_minLines) {
                            textView.setMinLines(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_minHeight) {
                            textView.setMinHeight(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_maxEms) {
                            textView.setMaxEms(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_maxWidth) {
                            textView.setMaxWidth(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_ems) {
                            textView.setEms(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_width) {
                            textView.setWidth(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_minEms) {
                            textView.setMinEms(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_minWidth) {
                            textView.setMinWidth(typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_gravity) {
                            textView.setGravity(typedArrayObtainStyledAttributes3.getInt(index2, -1));
                        } else if (index2 == R.styleable.TextView_android_scrollHorizontally) {
                            textView.setHorizontallyScrolling(typedArrayObtainStyledAttributes3.getBoolean(index2, false));
                        } else if (index2 == R.styleable.TextView_android_includeFontPadding) {
                            textView.setIncludeFontPadding(typedArrayObtainStyledAttributes3.getBoolean(index2, true));
                        } else if (index2 == R.styleable.TextView_android_cursorVisible) {
                            textView.setCursorVisible(typedArrayObtainStyledAttributes3.getBoolean(index2, true));
                        } else if (index2 == R.styleable.TextView_android_textScaleX) {
                            textView.setTextScaleX(typedArrayObtainStyledAttributes3.getFloat(index2, 1.0f));
                        } else if (index2 == R.styleable.TextView_android_shadowColor) {
                            i3 = typedArrayObtainStyledAttributes3.getInt(index2, 0);
                        } else {
                            if (index2 == R.styleable.TextView_android_shadowDx) {
                                f = typedArrayObtainStyledAttributes3.getFloat(index2, 0.0f);
                            } else if (index2 == R.styleable.TextView_android_shadowDy) {
                                f2 = typedArrayObtainStyledAttributes3.getFloat(index2, 0.0f);
                            } else if (index2 == R.styleable.TextView_android_shadowRadius) {
                                f4 = typedArrayObtainStyledAttributes3.getFloat(index2, 0.0f);
                            } else if (index2 == R.styleable.TextView_android_textColorHighlight) {
                                textView.setHighlightColor(typedArrayObtainStyledAttributes3.getColor(index2, 0));
                            } else if (index2 == R.styleable.TextView_android_textColor) {
                                textView.setTextColor(typedArrayObtainStyledAttributes3.getColorStateList(index2));
                            } else if (index2 == R.styleable.TextView_android_textColorHint) {
                                textView.setHintTextColor(typedArrayObtainStyledAttributes3.getColorStateList(index2));
                            } else if (index2 == R.styleable.TextView_android_textColorLink) {
                                textView.setLinkTextColor(typedArrayObtainStyledAttributes3.getColorStateList(index2));
                            } else if (index2 == R.styleable.TextView_android_textSize) {
                                textView.setTextSize(0, typedArrayObtainStyledAttributes3.getDimensionPixelSize(index2, 0));
                            } else if (index2 == R.styleable.TextView_android_typeface) {
                                i10 = typedArrayObtainStyledAttributes3.getInt(index2, -1);
                            } else if (index2 == R.styleable.TextView_android_textStyle) {
                                i11 = typedArrayObtainStyledAttributes3.getInt(index2, -1);
                            } else if (index2 == R.styleable.TextView_android_fontFamily || index2 == R.styleable.TextView_tv_fontFamily) {
                                String string2 = typedArrayObtainStyledAttributes3.getString(index2);
                                str = string2;
                            } else if (index2 == R.styleable.TextView_android_textAllCaps) {
                                if (Build.VERSION.SDK_INT >= 14) {
                                    textView.setAllCaps(typedArrayObtainStyledAttributes3.getBoolean(index2, false));
                                }
                            } else {
                                if (index2 == R.styleable.TextView_android_elegantTextHeight) {
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        textView.setElegantTextHeight(typedArrayObtainStyledAttributes3.getBoolean(index2, false));
                                    }
                                } else {
                                    if (index2 == R.styleable.TextView_android_letterSpacing) {
                                        if (Build.VERSION.SDK_INT >= 21) {
                                            textView.setLetterSpacing(typedArrayObtainStyledAttributes3.getFloat(index2, 0.0f));
                                        }
                                    } else if (index2 == R.styleable.TextView_android_fontFeatureSettings && Build.VERSION.SDK_INT >= 21) {
                                        textView.setFontFeatureSettings(typedArrayObtainStyledAttributes3.getString(index2));
                                    }
                                    i9++;
                                }
                                i9++;
                            }
                            i9++;
                        }
                        i9++;
                    }
                    i6 = indexCount2;
                    i9++;
                }
                i6 = indexCount2;
                z = true;
                i9++;
            }
            i6 = indexCount2;
            z2 = true;
            i9++;
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (i3 != 0) {
            textView.setShadowLayer(f4, f, f2, i3);
        }
        if (z2) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (drawable != null) {
                compoundDrawables[0] = drawable;
            } else if (drawable2 != null) {
                compoundDrawables[0] = drawable2;
            }
            if (drawable3 != null) {
                compoundDrawables[1] = drawable3;
            }
            if (drawable4 != null) {
                compoundDrawables[2] = drawable4;
            } else if (drawable5 != null) {
                compoundDrawables[2] = drawable5;
            }
            if (drawable6 != null) {
                compoundDrawables[3] = drawable6;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
        if (z && Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawable != null) {
                compoundDrawablesRelative[0] = drawable;
            }
            if (drawable4 != null) {
                compoundDrawablesRelative[2] = drawable4;
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
        if (str != null) {
            Typeface typefaceLoad = TypefaceUtil.load(textView.getContext(), str, i11);
            if (typefaceLoad != null) {
                textView.setTypeface(typefaceLoad);
            }
            typeface = typefaceLoad;
        } else {
            typeface = null;
        }
        if (typeface != null) {
            if (i10 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                typeface = Typeface.SERIF;
            } else if (i10 == 3) {
                typeface = Typeface.MONOSPACE;
            }
            textView.setTypeface(typeface, i11);
        }
        if (textView instanceof AutoCompleteTextView) {
            applyStyle((AutoCompleteTextView) textView, attributeSet, i, i2);
        }
    }

    private static void applyStyle(AutoCompleteTextView autoCompleteTextView, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = autoCompleteTextView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AutoCompleteTextView, i, i2);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.AutoCompleteTextView_android_completionHint) {
                autoCompleteTextView.setCompletionHint(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == R.styleable.AutoCompleteTextView_android_completionThreshold) {
                autoCompleteTextView.setThreshold(typedArrayObtainStyledAttributes.getInteger(index, 0));
            } else if (index == R.styleable.AutoCompleteTextView_android_dropDownAnchor) {
                autoCompleteTextView.setDropDownAnchor(typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == R.styleable.AutoCompleteTextView_android_dropDownHeight) {
                autoCompleteTextView.setDropDownHeight(typedArrayObtainStyledAttributes.getLayoutDimension(index, -2));
            } else if (index == R.styleable.AutoCompleteTextView_android_dropDownWidth) {
                autoCompleteTextView.setDropDownWidth(typedArrayObtainStyledAttributes.getLayoutDimension(index, -2));
            } else if (index == R.styleable.AutoCompleteTextView_android_dropDownHorizontalOffset) {
                autoCompleteTextView.setDropDownHorizontalOffset(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == R.styleable.AutoCompleteTextView_android_dropDownVerticalOffset) {
                autoCompleteTextView.setDropDownVerticalOffset(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == R.styleable.AutoCompleteTextView_android_popupBackground) {
                autoCompleteTextView.setDropDownBackgroundDrawable(typedArrayObtainStyledAttributes.getDrawable(index));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
